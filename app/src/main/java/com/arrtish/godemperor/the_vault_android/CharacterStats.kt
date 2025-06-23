package com.arrtish.godemperor.the_vault_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalHapticFeedback
import com.arrtish.godemperor.the_vault_android.ui.theme.TheVaultAndroidTheme

class CharacterStatsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheVaultAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CharacterStatsTopAppBar(onBackClick = { finish() },)
                    }
                ) { innerPadding ->
                    CharacterSheetView(
                        characterId = intent.getStringExtra("characterId").toString(),
                        modifier = Modifier.padding(innerPadding),
                        viewModel =  CharacterStatsViewModel()

                    )
                }
            }
        }
    }
}

@Composable
fun CharacterSheetView(characterId: String, modifier: Modifier, viewModel: CharacterStatsViewModel) {

    val buttonSize = 135.dp
    var currentHitPoints by remember { mutableStateOf("") }
    var maxHitPoints by remember { mutableStateOf("") }
    val haptic = LocalHapticFeedback.current
    var characterId = characterId

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
         // Change this to fit your layout needs

        Row(
            modifier = Modifier.padding(bottom = 16.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Profile Image
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Gray, shape = RoundedCornerShape(8.dp))
            ) {
                Text(
                    text = "Img",
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            // Character Info (Center)
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            ) {
                Text(text = "Name: ${characterId}", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = "Level: 5", fontSize = 16.sp)
                Text(text = "Race: Elf", fontSize = 16.sp)
            }


            // HP and AC (Top Right)
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "HP: ${currentHitPoints}", fontSize = 24.sp)
                HorizontalDivider(
                    modifier = Modifier
                        .width(40.dp)
                        .padding(vertical = 2.dp),
                    thickness = 1.dp
                )
                Text(text = "Max HP: ${maxHitPoints}", fontSize = 24.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "AC: 17", fontSize = 16.sp)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = "Subclass: Horizon Walker", fontSize = 16.sp)
            Text(text = "Class: Ranger", fontSize = 16.sp)
        }

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text("Edit Base Profile", textAlign = TextAlign.Center)
        }

        Spacer(modifier = Modifier.height(24.dp))

// 2x2 Button Grid with More Space Between Buttons
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp), // more vertical space between rows
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp), // more horizontal space between buttons
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                SquareButton("Stats", buttonSize) { /* Handle click */ }
                SquareButton("Features", buttonSize) { /* Handle click */ }
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp), // more horizontal space between buttons
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                SquareButton("Equipment", buttonSize) { /* Handle click */ }
                SquareButton("Spells", buttonSize) { /* Handle click */ }
            }
        }

    }
}

@Composable
fun SquareButton(label: String, size: Dp, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.size(size),
        shape = RoundedCornerShape(12.dp) // optional, for styling
    ) {
        Text(label, textAlign = TextAlign.Center)
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterStatsActivityPreview() {
    TheVaultAndroidTheme {
        CharacterSheetView(characterId = "", modifier = Modifier, viewModel =  CharacterStatsViewModel())
    }
}