package com.it.shka.feature_auth.domain.usecase

class ValidatePasswordUseCase {
    operator fun invoke(password: String): Boolean{
        return  password.length >= 6
    }
}