package com.arrtish.godemperor.the_vault_android.authentication
//
//import android.app.Application
//import android.content.Context
//import android.util.Log
//import android.widget.Toast
//import androidx.lifecycle.*
//import androidx.navigation.NavController
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//import org.mindrot.jbcrypt.BCrypt
//
//class LoginViewModel(application: Application) : AndroidViewModel(application) {
//    private val userDao = UserDatabase.getDatabase(application).userDao()
//
//    private val _loginResult = MutableStateFlow<Pair<Boolean, Boolean>?>(null)
//    val loginResult: StateFlow<Pair<Boolean, Boolean>?> = _loginResult
//
//    fun login(email: String, phoneNumber: String, password: String) {
//        viewModelScope.launch {
//            val user = userDao.getUserByEmailAndPhone(email.trim(), phoneNumber.trim())
//            if (user != null) {
//                // Check if the entered password matches the stored hashed password
//                val isPasswordCorrect = checkPassword(password, user.userPassword) // assuming `user.password` stores the hashed password
//                if (isPasswordCorrect) {
//                    _loginResult.value = true to true // Login success, correct password
//                } else {
//                    _loginResult.value = false to true // Login failed, incorrect password
//                }
//            } else {
//                _loginResult.value = false to false // Login failed, user not found
//            }
//        }
//    }
//
//    fun signUp(
//        name: String,
//        email: String,
//        confirmPassword: String,
//        password: String,
//        phoneNumber: String,
//        navController: NavController,
//        context: Context // To show Toast messages
//    ) {
//        viewModelScope.launch {
//            // Check if user already exists
//            val existingUser = userDao.getUserByEmailAndPhone(email, phoneNumber)
//            if (existingUser != null) {
//                _loginResult.value = false to true // User already exists
//                // Show a toast message
//                Toast.makeText(context, "User with this email already exists.", Toast.LENGTH_SHORT).show()
//            } else {
//                // Check if passwords match
//                if (confirmPassword == password) {
//                    // Insert user into the database
//                    userDao.insert(User(userName = name, userEmail = email, userPassword = hashPassword(password), userPhoneNumber = phoneNumber))
//                    _loginResult.value = true to true // Sign-up success
//                    // Show a success toast
//                    Toast.makeText(context, "Sign-up successful!", Toast.LENGTH_SHORT).show()
//
//                    // Navigate to the login screen
//                    navController.navigate("login") {
//                        // Clear the back stack to prevent the user from navigating back to the sign-up page
//                        popUpTo("signUp") { inclusive = true }
//                    }
//                } else {
//                    _loginResult.value = false to false // Passwords do not match
//                    // Show a toast message
//                    Toast.makeText(context, "Passwords do not match.", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//    }
//
//    fun clearLoginResult() {
//        _loginResult.value = null
//    }
//
//    fun hashPassword(password: String): String {
//        return BCrypt.hashpw(password, BCrypt.gensalt())
//    }
//
//    fun checkPassword(password: String, hashedPassword: String): Boolean {
//        return BCrypt.checkpw(password, hashedPassword)
//    }
//
//}
//
//class LoginViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return LoginViewModel(context.applicationContext as Application) as T
//    }
//}
