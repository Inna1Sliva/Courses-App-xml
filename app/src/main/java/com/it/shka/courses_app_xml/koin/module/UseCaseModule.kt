package com.it.shka.courses_app_xml.koin.module

import android.content.Context
import android.content.pm.PackageManager
import com.it.shka.feature_auth.domain.OpenUrlInBrowserUseCase
import com.it.shka.feature_auth.domain.ValidateEmailUseCase
import com.it.shka.feature_auth.domain.ValidatePasswordUseCase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val UseCaseModule = module {
    single<Context> { androidApplication() }
    single<PackageManager> {  get<Context>().packageManager }
    factory { ValidateEmailUseCase() }
    factory { ValidatePasswordUseCase() }
    factory { OpenUrlInBrowserUseCase(get<Context>(), get()) }
}
