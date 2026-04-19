package com.it.shka.feature_main.domain.model

data class Courses(
    val id: Int,
    val title: String,
    val text: String,
    val image: String,
    val price: String,
    val rate: String,
    val startDate: String,
    val hasLike: Boolean,
    val publishDate: String,
    val destination: String
)