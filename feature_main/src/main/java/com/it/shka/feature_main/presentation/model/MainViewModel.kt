package com.it.shka.feature_main.presentation.model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.it.shka.feature_main.domain.CoursesRepository
import com.it.shka.feature_main.domain.model.Courses
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val coursesRepository: CoursesRepository) : ViewModel() {

    private val _coursesState = MutableStateFlow<List<Courses>>(emptyList())
    val coursesState: StateFlow<List<Courses>> get() = _coursesState

    init {
        viewModelScope.launch {
            coursesRepository.getCourses()
                .onSuccess { courses ->
                    _coursesState.value = courses
                }
                .onFailure { Log.e("MainViewModel", "getCourses failed", it) }
        }
    }
}