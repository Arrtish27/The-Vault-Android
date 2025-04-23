package com.arrtish.godemperor.the_vault_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.arrtish.godemperor.the_vault_android.diceroller.DiceRoller
import com.arrtish.godemperor.the_vault_android.ui.theme.TheVaultAndroidTheme

class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheVaultAndroidTheme {
                val navController: NavHostController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        MyBottomAppBar(navController)
                    }
                ) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding)
                    ){
                        MyNavHost(navController)
                    }
                }
            }
        }
    }
}

// MyNavHost Composable function for navigation within the app
@Composable
fun MyNavHost(navController: NavHostController) {
    // NavHost composable to define the navigation graph
    val modifier = Modifier
    NavHost(
        // Use the provided NavHostController
        navController = navController,
        // Set the starting destination to "dice"
        startDestination = "dice"
    ) {
        // Define the composable for the "dice" route
        composable("dice") {
            DiceRoller(modifier)
        }
        // Define the composable for the "gallery" route
        composable("gallery") {
            CharacterGalleryView(modifier)
        }
    }
}

// Composable function for creating the bottom navigation bar.
@Composable
fun MyBottomAppBar(navController: NavHostController) {
    // State to track the currently selected item in the bottom navigation bar.
    var selectedItem by remember { mutableStateOf(0) }

    // List of navigation items: "home", "reports", "settings".
    val items = listOf(
        "dice",
        "gallery",
    )

    // NavigationBar composable to define the bottom navigation bar.
    NavigationBar {
        // Iterate through each item in the 'items' list along with its index.
        items.forEachIndexed { index, item ->
            // NavigationBarItem for each item in the list.
            NavigationBarItem(
                // Define the icon based on the item's name.
                icon = {
                    when (item) {
                        // If the item is "home", show the Home icon.
                        "dice" -> Icon(Icons.Filled.Home, contentDescription = "Dice")
                        // If the item is "reports", show the Email icon.
                        "gallery" -> Icon(Icons.Filled.Person, contentDescription = "Gallery")
                    }
                },
                // Display the item's name as the label.
                label = { Text(item) },
                // Determine if this item is currently selected.
                selected = selectedItem == index,
                // Actions to perform when this item is clicked.
                onClick = {
                    // Update the selectedItem state to the current index.
                    selectedItem = index
                    // Navigate to the corresponding screen based on the item's name.
                    navController.navigate(item)
                }
            )
        }
    }
}