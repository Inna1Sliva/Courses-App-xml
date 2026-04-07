package com.it.shka.feature_bottom_navigation.domain

import androidx.fragment.app.Fragment

fun interface TabFragmentFactory {
    fun create(tabIndex:Int): Fragment
}