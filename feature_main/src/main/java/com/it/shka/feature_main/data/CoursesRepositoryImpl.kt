package com.it.shka.feature_main.data

import com.it.shka.feature_main.data.network.ApiCourses
import com.it.shka.feature_main.domain.CoursesRepository
import com.it.shka.feature_main.domain.model.Courses
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CoursesRepositoryImpl(private val api: ApiCourses) : CoursesRepository {
    override suspend fun getCourses(): Result<List<Courses>> {
        return withContext(Dispatchers.IO) {
            runCatching {
                api.getCourses()
            }
        }
    }
}