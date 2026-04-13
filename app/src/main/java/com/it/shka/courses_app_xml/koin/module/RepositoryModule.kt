package com.it.shka.courses_app_xml.koin.module

import com.it.shka.feature_main.data.CoursesRepositoryImpl
import com.it.shka.feature_main.domain.CoursesRepository
import org.koin.dsl.module

val RepositoryModule = module {
    factory<CoursesRepository> { CoursesRepositoryImpl(get()) }
}