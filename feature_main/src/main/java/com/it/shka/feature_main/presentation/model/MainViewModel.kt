package com.it.shka.feature_main.presentation.model

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.it.shka.feature_main.domain.usecase.SortInDescendingOrderUseCase
import com.it.shka.feature_main.domain.repository.CoursesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val coursesRepository: CoursesRepository,
    private val sortInDescendingOrderUseCase: SortInDescendingOrderUseCase
) : ViewModel() {

    private val _coursesState = MutableStateFlow<CoursesState>(CoursesState.Loading)
    val coursesState: StateFlow<CoursesState> get() = _coursesState

    init {
        viewModelScope.launch {
            coursesRepository.getCourses()
                .onSuccess { courses ->
                    _coursesState.value = CoursesState.getCourses(courses)
                }
                .onFailure { Log.e("MainViewModel", "getCourses failed", it) }
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun sortInDescendingOrder(){
        viewModelScope.launch {
            _coursesState.value = CoursesState.Loading
            coursesRepository.getCourses().onSuccess { courses ->
                _coursesState.value = CoursesState.getCourses(sortInDescendingOrderUseCase(courses))
            }

        }
    }
}