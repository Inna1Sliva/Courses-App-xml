package com.it.shka.courses_app_xml.koin.module

import androidx.fragment.app.Fragment
import com.it.shka.feature_account.AccountFragment
import com.it.shka.feature_account.AccountFragmentProvider
import com.it.shka.feature_bottom_navigation.domain.NavigationFragment
import com.it.shka.feature_favourites.FavouritesFragment
import com.it.shka.feature_favourites.FavouritesFragmentProvider
import com.it.shka.feature_main.MainFragment
import com.it.shka.feature_main.MainFragmentProvider
import org.koin.dsl.module

val FragmentModule = module {
    single<MainFragmentProvider> { MainFragment() }
    single<FavouritesFragmentProvider> { FavouritesFragment() }
    single<AccountFragmentProvider> { AccountFragment() }
    factory<List<NavigationFragment>> {
        listOf(
            NavigationFragment(
                fragmentProvider = get<MainFragmentProvider>() as Fragment
            ),
            NavigationFragment(
                fragmentProvider = get<FavouritesFragmentProvider>() as Fragment
            ),
          NavigationFragment(
               fragmentProvider = get<AccountFragmentProvider>() as Fragment
            )
        )
    }
}