package com.it.shka.courses_app_xml.koin.module

import com.it.shka.courses_app_xml.presentation.model.AppMainViewModule
import com.it.shka.feature_auth.presentation.model.AuthViewModel
import com.it.shka.feature_main.presentation.model.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module{
    viewModel { AuthViewModel(get(), get(), get(), get()) }
    viewModel { AppMainViewModule(get()) }
    viewModel{ MainViewModel(get()) }
}