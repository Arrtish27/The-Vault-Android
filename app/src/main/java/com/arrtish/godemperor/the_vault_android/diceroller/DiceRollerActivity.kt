package com.arrtish.godemperor.the_vault_android.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.arrtish.godemperor.the_vault_android.ui.theme.TheVaultAndroidTheme

class DiceRollerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheVaultAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DiceRoller(
//                        name = "Android",
                        modifier = Modifier.padding(innerPadding),

                    )
                }
            }
        }
    }
}

@Composable
fun DiceRoller(modifier: Modifier = Modifier) {

    val viewModel: DiceRollerViewModel = viewModel()
    var diceRollResult by remember { mutableStateOf("") }
//    var diceRollMessage by remember { mutableStateOf("") }
    var diceRolled by remember { (mutableStateOf(DiceType.DICE_D20)) }
    val haptic = LocalHapticFeedback.current
    var numberOfDiceInput by remember { mutableStateOf("1") }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize().padding(30.dp)
    ) {
        Text(
            text = "Input an amount and press an Icon to roll that number of dice",
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center
        )

        TextField(
            value = numberOfDiceInput,
            onValueChange = { input ->
                // Only allow digits
                if (input.all { it.isDigit() }) {
                    numberOfDiceInput = input
                }
            },
            label = { Text("Enter amount") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(80.dp)
//                    .border(2.dp, Color.Black, RoundedCornerShape(8.dp))
                    .background(Color.Black)
                    .clickable(onClick = {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        if (numberOfDiceInput.isNotEmpty() && numberOfDiceInput.all { it.isDigit() }) {
                            val diceCount = numberOfDiceInput.toInt()
                            val result = viewModel.rollDice(diceCount, DiceType.DICE_D4)
                            diceRollResult = result.first.toString()
                            diceRolled = result.second
                        } else {
                            // Handle invalid input, you can show an error message here if needed
                            diceRollResult = "Invalid number of dice"
                        }
                    })
            ) {
                Image(
                    painter = painterResource(DiceType.DICE_D4.imageId),
                    contentDescription = "D4",
                    modifier = Modifier.size(80.dp)
                )
            }

//            Spacer(modifier = Modifier.height(16.dp))

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(80.dp)
//                    .border(2.dp, Color.Black, RoundedCornerShape(8.dp))
                    .background(Color.Black)
                    .clickable(onClick = {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        if (numberOfDiceInput.isNotEmpty() && numberOfDiceInput.all { it.isDigit() }) {
                            val diceCount = numberOfDiceInput.toInt()
                            val result = viewModel.rollDice(diceCount, DiceType.DICE_D6)
                            diceRollResult = result.first.toString()
                            diceRolled = result.second
                        } else {
                            // Handle invalid input, you can show an error message here if needed
                            diceRollResult = "Invalid number of dice"
                        }
                    })
            ) {
                Image(
                    painter = painterResource(DiceType.DICE_D6.imageId),
                    contentDescription = "D6",
                    modifier = Modifier.size(80.dp)
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(80.dp)
//                    .border(2.dp, Color.Black, RoundedCornerShape(8.dp))
                    .background(Color.Black)
                    .clickable(onClick = {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        if (numberOfDiceInput.isNotEmpty() && numberOfDiceInput.all { it.isDigit() }) {
                            val diceCount = numberOfDiceInput.toInt()
                            val result = viewModel.rollDice(diceCount, DiceType.DICE_D8)
                            diceRollResult = result.first.toString()
                            diceRolled = result.second
                        } else {
                            // Handle invalid input, you can show an error message here if needed
                            diceRollResult = "Invalid number of dice"
                        }
                    })
            ) {
                Image(
                    painter = painterResource(id = DiceType.DICE_D8.imageId),
                    contentDescription = "D8",
                    modifier = Modifier.size(80.dp)
                )
            }

//            Spacer(modifier = Modifier.height(16.dp))

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(80.dp)
//                    .border(2.dp, Color.Black, RoundedCornerShape(8.dp))
                    .background(Color.Black)
                    .clickable(onClick = {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        if (numberOfDiceInput.isNotEmpty() && numberOfDiceInput.all { it.isDigit() }) {
                            val diceCount = numberOfDiceInput.toInt()
                            val result = viewModel.rollDice(diceCount, DiceType.DICE_D10)
                            diceRollResult = result.first.toString()
                            diceRolled = result.second
                        } else {
                            // Handle invalid input, you can show an error message here if needed
                            diceRollResult = "Invalid number of dice"
                        }
                    })
            ) {
                Image(
                    painter = painterResource(id = DiceType.DICE_D10.imageId),
                    contentDescription = "D10",
                    modifier = Modifier.size(80.dp)
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(80.dp)
//                    .border(2.dp, Color.Black, RoundedCornerShape(8.dp))
                    .background(Color.Black)
                    .clickable(onClick = {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        if (numberOfDiceInput.isNotEmpty() && numberOfDiceInput.all { it.isDigit() }) {
                            val diceCount = numberOfDiceInput.toInt()
                            val result = viewModel.rollDice(diceCount, DiceType.DICE_D12)
                            diceRollResult = result.first.toString()
                            diceRolled = result.second
                        } else {
                            // Handle invalid input, you can show an error message here if needed
                            diceRollResult = "Invalid number of dice"
                        }
                    })
            ) {
                Image(
                    painter = painterResource(id = DiceType.DICE_D12.imageId),
                    contentDescription = "D12",
                    modifier = Modifier.size(80.dp)
                )
            }

//            Spacer(modifier = Modifier.height(16.dp))

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(80.dp)
//                    .border(2.dp, Color.Black, RoundedCornerShape(8.dp))
                    .background(Color.Black)
                    .clickable(onClick = {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        if (numberOfDiceInput.isNotEmpty() && numberOfDiceInput.all { it.isDigit() }) {
                            val diceCount = numberOfDiceInput.toInt()
                            val result = viewModel.rollDice(diceCount, DiceType.DICE_D20)
                            diceRollResult = result.first.toString()
                            diceRolled = result.second
                        } else {
                            // Handle invalid input, you can show an error message here if needed
                            diceRollResult = "Invalid number of dice"
                        }
                    })
            ) {
                Image(
                    painter = painterResource(id = DiceType.DICE_D20.imageId),
                    contentDescription = "D20",
                    modifier = Modifier.size(80.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "You rolled a ${diceRolled.printName}",
            color = diceRolled.color,
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp)
        )

        if (numberOfDiceInput.isNotEmpty() && numberOfDiceInput.toInt() > 1) {
            // If more than 1 die, show individual results and total sum
            val resultsList = diceRollResult.split(", ")
            val sum = resultsList.sumOf { it.toIntOrNull() ?: 0 }
            Text(
                text = "Rolled Dice: ${resultsList.joinToString(", ")}",
                fontSize = 18.sp,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = "Total Sum: $sum",
                fontSize = 20.sp,
                color = diceRolled.color,
                modifier = Modifier.padding(16.dp)
            )
        } else {
            // For single die, just show the result
            Text(
                text = "Result: $diceRollResult",
                fontSize = 20.sp,
                color = diceRolled.color,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerPreview() {
    TheVaultAndroidTheme {
        DiceRoller(modifier = Modifier)
    }
}