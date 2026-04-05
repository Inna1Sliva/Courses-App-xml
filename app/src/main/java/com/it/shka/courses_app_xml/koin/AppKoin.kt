package com.it.shka.courses_app_xml.koin

import android.app.Application
import com.it.shka.courses_app_xml.koin.module.FragmentModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class AppKoin : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@AppKoin)
            modules(
                FragmentModule
            )
        }
    }
}