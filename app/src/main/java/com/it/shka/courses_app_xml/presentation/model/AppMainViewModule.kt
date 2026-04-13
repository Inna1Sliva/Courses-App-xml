package com.it.shka.courses_app_xml.presentation.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.it.shka.core.UserTokenStorage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AppMainViewModule(private val userTokenStorage: UserTokenStorage) : ViewModel() {
    //  val userToken: StateFlow<String> = userTokenStorage.token.stateIn(viewModelScope,
    // SharingStarted.WhileSubscribed(1000),"")
    private val _authState = MutableStateFlow<AuthState>(AuthState.Loading)
    val authState: StateFlow<AuthState> = _authState

    init {
        viewModelScope.launch {
            userTokenStorage.token.collect { token->
                _authState.value = when {
                    token.isNotEmpty() -> AuthState.Authenticated
                    else -> AuthState.Unauthenticated
                }
            }
        }
    }
}