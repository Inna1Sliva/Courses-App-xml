package com.it.shka.feature_main.domain.usecase

import android.os.Build
import androidx.annotation.RequiresApi
import com.it.shka.feature_main.domain.model.Courses
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class SortInDescendingOrderUseCase() {
    @RequiresApi(Build.VERSION_CODES.O)
    operator fun invoke(courses: List<Courses>): List<Courses> {
        return courses.sortedByDescending { courses ->
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            LocalDate.parse(courses.publishDate, formatter)
        }

    }
}