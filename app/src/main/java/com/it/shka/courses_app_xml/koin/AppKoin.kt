package com.it.shka.courses_app_xml.koin

import android.app.Application
import com.it.shka.courses_app_xml.koin.module.DataStoreModule
import com.it.shka.courses_app_xml.koin.module.FragmentModule
import com.it.shka.courses_app_xml.koin.module.NetworkModule
import com.it.shka.courses_app_xml.koin.module.RepositoryModule
import com.it.shka.courses_app_xml.koin.module.UseCaseModule
import com.it.shka.courses_app_xml.koin.module.ViewModelModule
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
                FragmentModule,
                ViewModelModule,
                UseCaseModule,
                DataStoreModule,
                NetworkModule,
                RepositoryModule
            )
        }
    }
}