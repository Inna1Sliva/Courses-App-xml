package com.it.shka.courses_app_xml.koin.module

import com.it.shka.feature_main.data.repository.CoursesRepositoryImpl
import com.it.shka.feature_main.domain.repository.CoursesRepository
import org.koin.dsl.module

val RepositoryModule = module {
    factory<CoursesRepository> { CoursesRepositoryImpl(get()) }
}