package com.it.shka.courses_app_xml.koin.module

import com.it.shka.core.UserTokenStorage
import org.koin.dsl.module

val DataStoreModule = module {
    single{ UserTokenStorage(get()) }
}