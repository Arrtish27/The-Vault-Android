package com.arrtish.godemperor.the_vault_android.characterview

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CharacterGalleryView(
    modifier: Modifier,
    navController: NavController,
) {
    val characterIdList = listOf("001", "002", "003", "004", "005", "006", "007", "008", "009")

    Column(modifier = modifier.padding(16.dp)) {
        Text(text = "All Characters")

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(characterIdList.size) { index ->
                val characterId = characterIdList[index]

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
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

                    Button(
                        onClick = {
                            navController.navigate("character_stats/${characterId}")
                        },
                        modifier = Modifier.padding(top = 8.dp)
                    ) {
                        Text(text = "Character ID: $characterId")
                    }
                }
            }
        }
    }
}
