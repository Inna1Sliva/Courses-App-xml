package com.it.shka.feature_main.domain.repository

import com.it.shka.feature_main.domain.model.Courses

interface CoursesRepository {
    suspend fun getCourses(): Result<List<Courses>>
}