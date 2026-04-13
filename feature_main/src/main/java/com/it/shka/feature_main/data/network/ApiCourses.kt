package com.it.shka.feature_main.data.network

import com.it.shka.feature_main.domain.model.Courses
import retrofit2.http.GET

interface ApiCourses {
    @GET("/courses_page")
    suspend fun getCourses(): List<Courses>
}
