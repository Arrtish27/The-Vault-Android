package com.arrtish.godemperor.the_vault_android.diceroller

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun DiceRoller(
    modifier: Modifier,
    navController: NavController,
) {
    val viewModel: DiceRollerViewModel = viewModel()
    var diceRollResult by remember { mutableStateOf<Pair<Any, Int>?>(null) }
    var diceRolled by remember { mutableStateOf(DiceType.DICE_D20) }
    val haptic = LocalHapticFeedback.current
    var numberOfDiceInput by remember { mutableStateOf("1") }
    val scrollState = rememberScrollState()


    fun handleDiceRoll(type: DiceType) {
        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
        val diceCount = numberOfDiceInput.toInt()
        val result = viewModel.rollDice(diceCount, type)
        Log.v("Result", "${result}")
        val result1 = result.first
        val result2 = result.second
        diceRollResult = Pair(result1, result2)
        diceRolled = type
    }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize().padding(30.dp).verticalScroll(scrollState)
    ) {
        Text(
            text = "Input an amount and press an Icon to roll that number of dice",
            fontSize = 18.sp,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center
        )

        TextField(
            value = numberOfDiceInput,
            onValueChange = { input -> if (input.all { it.isDigit() }) numberOfDiceInput = input },
            label = { Text("Enter amount") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )

        // Row builder for reusable dice buttons
        @Composable
        fun DiceRow(vararg types: DiceType) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                types.forEach { type ->
                    DiceButton(type = type) { handleDiceRoll(type) }
                }
            }
        }

        DiceRow(DiceType.DICE_D4, DiceType.DICE_D6)
        DiceRow(DiceType.DICE_D8, DiceType.DICE_D10)
        DiceRow(DiceType.DICE_D12, DiceType.DICE_D20)

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "You rolled a ${diceRolled.printName}",
            color = diceRolled.color,
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp)
        )

        if (numberOfDiceInput.isNotEmpty() && numberOfDiceInput.toInt() > 1) {
            // If more than 1 die, show individual results and total sum
            diceRollResult?.let { (rolled, sum) ->
                if (rolled is List<*>) {
                    // Handle the case where multiple dice were rolled (List<Int>)
                    val resultsList = rolled.filterIsInstance<Int>()
                    val totalSum = resultsList.sum()

                    Text(
                        text = "Rolled Dice: ${resultsList.joinToString(", ")}",
                        fontSize = 18.sp,
                        modifier = Modifier.padding(16.dp)
                    )
                    Text(
                        text = "Total Sum: $totalSum",
                        fontSize = 20.sp,
                        color = diceRolled.color,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        } else {
            // For single die, just show the result
            diceRollResult?.let { (rolled, sum) ->
                if (rolled is Int) {
                    // Handle the case where only one die was rolled (Int result)
                    Text(
                        text = "Result: $rolled",
                        fontSize = 20.sp,
                        color = diceRolled.color,
                        modifier = Modifier.padding(16.dp)
                    )
                } else if (rolled is String) {
                    // Handle the case of an invalid roll, e.g., "Invalid number of dice"
                    Text(
                        text = "Error: $rolled",
                        fontSize = 20.sp,
                        color = Color.Red, // You can choose to set an error color
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun DiceButton(type: DiceType, onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(80.dp)
            .background(Color.Black)
            .clickable(onClick = onClick)
    ) {
        Image(
            painter = painterResource(id = type.imageId),
            contentDescription = type.printName,
            modifier = Modifier.size(80.dp)
        )
    }
}