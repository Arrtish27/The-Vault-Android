package com.arrtish.godemperor.the_vault_android

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
//import com.arrtish.godemperor.the_vault_android.authentication.LoginView
//import com.arrtish.godemperor.the_vault_android.authentication.SignUpView
import com.arrtish.godemperor.the_vault_android.diceroller.DiceRoller
import com.arrtish.godemperor.the_vault_android.ui.theme.TheVaultAndroidTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheVaultAndroidTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize(), topBar = { MyTopAppBar(navController) }, bottomBar = { MyBottomAppBar(navController) } )  { innerPadding ->
                    AppNavigation(modifier = Modifier.padding(innerPadding), navController)
                }
            }
        }
    }
}

@Composable
fun AppNavigation(modifier: Modifier, navController: NavHostController) {
    NavHost(navController = navController, startDestination = "dice") {
//        composable("login") { LoginView(modifier, navController) }
//        composable("signup") { SignUpView(modifier, navController) }
        composable("dice") { DiceRoller(modifier, navController) }
        composable("gallery") { CharacterGalleryView(modifier, navController) }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(navController: NavHostController) {
    // Track the current route
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route ?: "Home"

    // State to manage the menu's visibility
    var expanded by remember { mutableStateOf(false) }

    // Get context from LocalContext
    val context = LocalContext.current

    TopAppBar(
        title = { Text(currentRoute.replaceFirstChar { it.uppercase() }) }, // Display the route name as title
        actions = {
            IconButton(onClick = { expanded = !expanded }) {
                Icon(Icons.Filled.MoreVert, contentDescription = "More options")
            }

            // Dropdown menu for the log out option
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    onClick = {
                        val intent = Intent(context, MainActivity::class.java).apply {
                            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        }
                        context.startActivity(intent)
                        expanded = false
                    },
                    text = { Text("Log out") }
                )
            }
        }
    )
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

