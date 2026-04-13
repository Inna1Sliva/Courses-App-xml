package com.it.shka.courses_app_xml.koin.module

import android.content.Context
import android.content.pm.PackageManager
import com.it.shka.feature_auth.domain.usecase.OpenUrlInBrowserUseCase
import com.it.shka.feature_auth.domain.usecase.ValidateEmailUseCase
import com.it.shka.feature_auth.domain.usecase.ValidatePasswordUseCase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val UseCaseModule = module {
    single<Context> { androidApplication() }
    single<PackageManager> {  get<Context>().packageManager }
    factory { ValidateEmailUseCase() }
    factory { ValidatePasswordUseCase() }
    factory { OpenUrlInBrowserUseCase(get<Context>(), get()) }
}
