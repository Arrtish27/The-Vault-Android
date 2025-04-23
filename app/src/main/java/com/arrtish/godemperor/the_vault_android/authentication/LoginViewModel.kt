package com.arrtish.godemperor.the_vault_android.authentication

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val userDao = UserDatabase.getDatabase(application).userDao()

    private val _loginResult = MutableStateFlow<Pair<Boolean, Boolean>?>(null)
    val loginResult: StateFlow<Pair<Boolean, Boolean>?> = _loginResult

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val user = userDao.getUser(email, password)
            if (user != null) {
                _loginResult.value = true to false
            } else {
                userDao.insert(User(userEmail = email, userPassword = password))
                _loginResult.value = true to true
            }
        }
    }

    fun clearLoginResult() {
        _loginResult.value = null
    }
}

class LoginViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(context.applicationContext as Application) as T
    }
}
