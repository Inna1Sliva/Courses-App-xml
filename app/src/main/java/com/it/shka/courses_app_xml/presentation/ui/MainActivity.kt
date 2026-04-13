package com.it.shka.courses_app_xml.presentation.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import com.it.shka.courses_app_xml.R
import com.it.shka.courses_app_xml.presentation.model.AuthState
import com.it.shka.courses_app_xml.presentation.model.AppMainViewModule
import com.it.shka.feature_auth.presentation.ui.AuthFragment
import com.it.shka.feature_bottom_navigation.presentation.BottomNavFragment
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val vm: AppMainViewModule by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            vm.authState.collect { state ->
                when(state) {
                    is AuthState.Loading -> {}
                    is AuthState.Authenticated -> {navigateToBottomFragment()}
                    is AuthState.Unauthenticated -> {navigateToRegistrationFragment()}
                }
            }
        }

    }
    private fun navigateToRegistrationFragment() {
        supportFragmentManager.commit {
            replace(android.R.id.content, AuthFragment())
            setReorderingAllowed(true)
        }
    }
    private fun navigateToBottomFragment() {
        supportFragmentManager.commit {
            replace(android.R.id.content, BottomNavFragment())
            setReorderingAllowed(true)
        }
    }
}