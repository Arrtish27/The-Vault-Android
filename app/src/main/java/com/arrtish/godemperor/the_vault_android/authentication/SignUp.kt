package com.arrtish.godemperor.the_vault_android.authentication
//
//import android.content.Intent
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavController
//import androidx.compose.foundation.rememberScrollState
//import com.arrtish.godemperor.the_vault_android.ui.theme.TheVaultAndroidTheme
//
//class SignUpActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//    }
//}
//
//@Composable
//fun SignUpView(
//    modifier: Modifier,
//    navController: NavController,
//    viewModel: LoginViewModel = viewModel(factory = LoginViewModelFactory(LocalContext.current))
//) {
//    var name by remember { mutableStateOf("") }
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//    var confirmPassword by remember { mutableStateOf("") }
//    var phoneNumber by remember { mutableStateOf("") }
//    val context = LocalContext.current
//    val scrollState = rememberScrollState()
//
//    var isPasswordValid by remember { mutableStateOf(false) }
//    var isConfirmPasswordValid by remember { mutableStateOf(false) }
//    var passwordError by remember { mutableStateOf("") }
//    var confirmPasswordError by remember { mutableStateOf("") }
//
//    val passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#\$%^&*(),.?\":{}|<>])[A-Za-z\\d!@#\$%^&*(),.?\":{}|<>]{10,}$" // 10 chars min, 1 caps, 1 small, 1 number, 1 symbol
//
//    fun validatePassword() {
//        isPasswordValid = password.matches(Regex(passwordPattern))
//        passwordError = if (isPasswordValid) "" else "Password must be at least 10 characters long, with at least one uppercase letter, one lowercase letter, one number, and one symbol."
//    }
//
//    fun validateConfirmPassword() {
//        isConfirmPasswordValid = password == confirmPassword
//        confirmPasswordError = if (isConfirmPasswordValid) "" else "Passwords do not match."
//    }
//
//    LaunchedEffect(password) {
//        validatePassword()
//        validateConfirmPassword()
//    }
//    LaunchedEffect(confirmPassword) {
//        validateConfirmPassword()
//    }
//
//    Column(
//        modifier = modifier
//            .fillMaxSize()
//            .padding(16.dp)
//            .verticalScroll(scrollState),  // Corrected placement here
//        verticalArrangement = Arrangement.Center
//    ){
//        Text(text = "Sign Up", style = MaterialTheme.typography.headlineMedium)
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        OutlinedTextField(
//            value = name,
//            onValueChange = { name = it },
//            label = { Text("Name") },
//            placeholder = { Text("Arrtish") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        OutlinedTextField(
//            value = email,
//            onValueChange = { email = it },
//            label = { Text("Email") },
//            placeholder = { Text("•••••••@gmail.com") },
//            modifier = Modifier.fillMaxWidth(),
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
//        )
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        OutlinedTextField(
//            value = password,
//            onValueChange = { password = it },
//            label = { Text("Password") },
//            modifier = Modifier.fillMaxWidth(),
//            visualTransformation = PasswordVisualTransformation(),
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//            isError = !isPasswordValid,
//            supportingText = {
//                if (!isPasswordValid) {
//                    Text(passwordError, color = MaterialTheme.colorScheme.error)
//                }
//            }
//        )
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        OutlinedTextField(
//            value = confirmPassword,
//            onValueChange = { confirmPassword = it },
//            label = { Text("Confirm Password") },
//            modifier = Modifier.fillMaxWidth(),
//            visualTransformation = PasswordVisualTransformation(),
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//            isError = !isConfirmPasswordValid,
//            supportingText = {
//                if (!isConfirmPasswordValid) {
//                    Text(confirmPasswordError, color = MaterialTheme.colorScheme.error)
//                }
//            }
//        )
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        OutlinedTextField(
//            value = phoneNumber,
//            onValueChange = { phoneNumber = it },
//            label = { Text("Phone Number") },
//            placeholder = { Text("0•••••••••") },
//            modifier = Modifier.fillMaxWidth(),
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(
//            onClick = {
//                viewModel.signUp(name,email.trim(), password, confirmPassword, phoneNumber, navController, context)
//            },
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text("Sign Up")
//        }
//
//        Button(
//            onClick = {
//                navController.navigate("Return to Login")
//            },
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text("Return to Login")
//        }
//
//    }
//}