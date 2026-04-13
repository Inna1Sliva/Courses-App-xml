package com.it.shka.courses_app_xml.presentation.model

sealed class AuthState {
    object Loading: AuthState()
    object Unauthenticated : AuthState()
    object Authenticated : AuthState()
}
