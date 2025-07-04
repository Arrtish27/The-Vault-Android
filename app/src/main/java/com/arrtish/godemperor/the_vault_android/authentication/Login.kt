package com.arrtish.godemperor.the_vault_android.authentication
//
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Toast
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.core.content.ContextCompat.startActivity
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavController
//import com.arrtish.godemperor.the_vault_android.ui.theme.TheVaultAndroidTheme
//
//class LoginActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//    }
//}
//
//@Composable
//fun LoginView(
//    modifier: Modifier = Modifier,
//    navController: NavController,
//    viewModel: LoginViewModel = viewModel(factory = LoginViewModelFactory(LocalContext.current))
//) {
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//    var phoneNumber by remember { mutableStateOf("") }
//    val context = LocalContext.current
//    val loginResult by viewModel.loginResult.collectAsState()
//
//    LaunchedEffect(loginResult) {
//        loginResult?.let { (success, isNewUser) ->
//            if (success) {
//                if (isNewUser){
//                    val msg =  "Welcome to the Vault"
//                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
//                } else {
//                    val msg =  "Welcome back!"
//                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
//                }
//                val intent = Intent(context, HomeActivity::class.java).apply {
//                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//                }
//                context.startActivity(intent)
//            } else {
//                Toast.makeText(context, "Login failed", Toast.LENGTH_SHORT).show()
//            }
//            viewModel.clearLoginResult()
//        }
//    }
//
//    Column(
//        modifier = modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(text = "Login", style = MaterialTheme.typography.headlineMedium)
//
//        Spacer(modifier = Modifier.height(24.dp))
//
//        OutlinedTextField(
//            value = email,
//            onValueChange = { email = it },
//            label = { Text("Email") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        OutlinedTextField(
//            value = password,
//            onValueChange = { password = it },
//            label = { Text("Password") },
//            visualTransformation = PasswordVisualTransformation(),
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        OutlinedTextField(
//            value = phoneNumber,
//            onValueChange = { phoneNumber = it },
//            label = { Text("Phone Number") },
//            modifier = Modifier.fillMaxWidth(),
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
//        )
//
//        Spacer(modifier = Modifier.height(24.dp))
//
//        Button(
//            onClick = {
//                viewModel.login(email.trim(), phoneNumber, password)
//            },
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text("Login")
//        }
//
//        Button(
//            onClick = {
//                navController.navigate("signup")
//            },
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text("Create New Account")
//        }
//    }
//}
//
////@Preview(showBackground = true)
////@Composable
////fun LoginPreview() {
////    TheVaultAndroidTheme {
////        LoginView()
////    }
////}
