package com.it.shka.feature_main.domain

import com.it.shka.feature_main.domain.model.Courses
import kotlinx.coroutines.flow.Flow

interface CoursesRepository {
    suspend fun getCourses(): Result<List<Courses>>
}