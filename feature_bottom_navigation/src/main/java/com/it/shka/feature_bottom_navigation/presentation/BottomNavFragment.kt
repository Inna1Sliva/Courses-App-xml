package com.it.shka.feature_bottom_navigation.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.it.shka.feature_bottom_navigation.R
import com.it.shka.feature_bottom_navigation.databinding.FragmentBottomNavBinding
import com.it.shka.feature_bottom_navigation.domain.TabFragmentFactory
import org.koin.android.ext.android.inject

@Suppress("DEPRECATION")
class BottomNavFragment : Fragment() {
    private val  tabFragmentFactory: TabFragmentFactory by inject()
    private var _binding: FragmentBottomNavBinding? = null
    private val binding get() = _binding!!
    private val fragments = mutableMapOf<Int, Fragment>()
    private var activeIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBottomNavBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBottomNavigation()
        showFragment(0)
    }

    private fun showFragment(index: Int) {
        val fm = childFragmentManager
        val transaction = fm.beginTransaction()

        fragments[activeIndex]?.let { transaction.hide(it) }

        val fragment = fragments.getOrPut(index) {
            tabFragmentFactory.create(index).also {
                transaction.add(R.id.fragment_container, it, "tab_$index")
            }
        }

        transaction.show(fragment).commit()
        activeIndex = index
    }

    private fun setupBottomNavigation() {
      binding.bottomNavigation.selectedItemId = R.id.nav_home
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> showFragment(0)
                R.id.nav_bookmark -> showFragment(1)
                R.id.nav_account -> showFragment(2)
                else -> return@setOnNavigationItemSelectedListener false
            }
            true
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}