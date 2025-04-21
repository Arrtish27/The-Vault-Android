package com.arrtish.godemperor.thevault

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                        viewModel = DiceRollerViewModel()
                    )
                }
            }
        }
    }
}

@Composable
fun DiceRoller(modifier: Modifier = Modifier, viewModel: DiceRollerViewModel) {

    var diceRollResult by remember { mutableStateOf("") }
//    var diceRollMessage by remember { mutableStateOf("") }
    var diceRolled by remember { (mutableStateOf(DiceType.DICE_D20)) }
    val haptic = LocalHapticFeedback.current

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize().padding(30.dp)
    ) {
        Text(
            text = "Click an Icon to roll that Die",
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center
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
                        haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                        val result = viewModel.rollDice(DiceType.DICE_D4)
                        diceRollResult = result.first.toString()
                        diceRolled = result.second
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
                        haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                        val result = viewModel.rollDice(DiceType.DICE_D6)
                        diceRollResult = result.first.toString()
                        diceRolled = result.second
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
                        haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                        val result = viewModel.rollDice(DiceType.DICE_D8)
                        diceRollResult = result.first.toString()
                        diceRolled = result.second
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
                        haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                        val result = viewModel.rollDice(DiceType.DICE_D10)
                        diceRollResult = result.first.toString()
                        diceRolled = result.second
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
                        haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                        val result = viewModel.rollDice(DiceType.DICE_D12)
                        diceRollResult = result.first.toString()
                        diceRolled = result.second
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
                        haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                        val result = viewModel.rollDice(DiceType.DICE_D20)
                        diceRollResult = result.first.toString()
                        diceRolled = result.second
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
            text = "${diceRolled.printName} Rolled ",
            color = diceRolled.color,
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "Result: ${diceRollResult}",
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerPreview() {
    TheVaultAndroidTheme {
        DiceRoller(modifier = Modifier, viewModel = DiceRollerViewModel())
    }
}