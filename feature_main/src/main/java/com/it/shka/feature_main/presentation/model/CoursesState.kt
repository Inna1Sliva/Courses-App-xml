package com.it.shka.feature_main.presentation.model

import com.it.shka.feature_main.domain.model.Courses

sealed class CoursesState {
    object Loading: CoursesState()
    data class getCourses (val courses: List<Courses>): CoursesState()
}