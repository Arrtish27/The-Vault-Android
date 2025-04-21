package com.arrtish.godemperor.thevault

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.arrtish.godemperor.the_vault_android.ui.theme.TheVaultAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheVaultAndroidTheme {
                Scaffold(
//                    bottomBar = NavigationBar () { },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    MainView(
//                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainView (modifier: Modifier){
    val context = LocalContext.current

    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment =  Alignment.CenterVertically,
            modifier = modifier.fillMaxWidth()
        ){
            Button(
                modifier = Modifier,
                onClick = {
                    val intent = Intent(context, DiceRollerActivity()::class.java)
                    context.startActivity(intent)
                }
            ) {
                Text("Go to Dice Roller")
            }
        }
    }
}