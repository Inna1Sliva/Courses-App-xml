package com.it.shka.courses_app_xml.koin.module

import com.it.shka.feature_auth.presentation.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module{
    viewModel { AuthViewModel(get(), get(), get()) }
}