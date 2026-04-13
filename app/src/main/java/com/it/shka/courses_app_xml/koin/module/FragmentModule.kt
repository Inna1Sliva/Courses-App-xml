package com.it.shka.courses_app_xml.koin.module

import androidx.fragment.app.Fragment
import com.it.shka.courses_app_xml.R
import com.it.shka.feature_account.AccountFragment
import com.it.shka.feature_bottom_navigation.domain.TabFragmentFactory
import com.it.shka.feature_favourites.FavouritesFragment
import com.it.shka.feature_main.presentation.MainFragment
import org.koin.dsl.module
import java.lang.IllegalArgumentException

val FragmentModule = module {

    factory<TabFragmentFactory> {
        TabFragmentFactory { tabIndex ->
            when (tabIndex) {
                0 -> MainFragment()
                1 -> FavouritesFragment()
                2 -> AccountFragment()
                else -> throw IllegalArgumentException("Unknown tab index: $tabIndex")
            }
        }
    }
}