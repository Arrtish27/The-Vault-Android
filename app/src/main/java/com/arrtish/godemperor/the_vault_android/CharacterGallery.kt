package com.arrtish.godemperor.the_vault_android

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

//class CharacterGalleryActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            TheVaultAndroidTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    CharacterGalleryView(
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
//    }
//}

@Composable
fun CharacterGalleryView(
    modifier: Modifier,
    navController: NavController,
) {
    val context = LocalContext.current
    val characterIdList = listOf("001", "002", "003", "003", "003", "003", "003", "003", "003")
    Text(text="All characters")

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(characterIdList.size) { characterId ->
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
                        val intent = Intent(context, CharacterStatsActivity::class.java).apply {
                            putExtra("characterId", characterId)
                        }
                        context.startActivity(intent)
                    },
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text(text = "Character ID: $characterId")
                }
            }
        }
    }
}