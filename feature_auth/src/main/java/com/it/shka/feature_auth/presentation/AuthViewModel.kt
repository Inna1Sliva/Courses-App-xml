package com.it.shka.feature_auth.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.it.shka.feature_auth.domain.OpenUrlInBrowserUseCase
import com.it.shka.feature_auth.domain.ValidateEmailUseCase
import com.it.shka.feature_auth.domain.ValidatePasswordUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class AuthViewModel(
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val openUrlInBrowserUseCase: OpenUrlInBrowserUseCase
) : ViewModel() {
    private val _email = MutableStateFlow("")
    private val _password = MutableStateFlow("")
    private val _state = MutableStateFlow(false)
    val state: StateFlow<Boolean> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            combine(_email, _password) { email, password ->
                validateCredentialsUser(email, password)
            }.collect { isValid ->
                _state.value = isValid
            }
        }
    }
    fun openBrowser(url:String){
        viewModelScope.launch {
            openUrlInBrowserUseCase.execute(url)
                .onSuccess {
                    Log.e("openUrlInBrowserUseCase", "open Browser")
                }
                .onFailure {
                    Log.e("openUrlInBrowserUseCase", "not open Browser $it")
            }
        }
    }

    fun onEmailChanged(email: String) {
        _email.value = email
    }

    fun onPasswordChanged(password: String) {
        _password.value = password
    }

    private fun validateCredentialsUser(email: String, password: String): Boolean {
        return validateEmailUseCase(email) && validatePasswordUseCase(password)
    }
}