package com.it.shka.feature_auth.domain

class ValidatePasswordUseCase {
    operator fun invoke(password: String): Boolean{
        return  password.length >= 6
    }
}