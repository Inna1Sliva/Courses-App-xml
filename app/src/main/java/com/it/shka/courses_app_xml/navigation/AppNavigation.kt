package com.it.shka.courses_app_xml.navigation

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment



class AppNavigation(){


init {

}

    fun navigationToBottom(){
        navController.navigate(com.it.shka.feature_bottom_navigation.R.id.bottom_navigation)
    }
}