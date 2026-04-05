package com.it.shka.feature_favourites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.it.shka.feature_favourites.databinding.FragmentFavouritesBinding

class FavouritesFragment : Fragment(), FavouritesFragmentProvider {
    override fun provideFavouritesFragment(): Fragment = this
    private var _binding: FragmentFavouritesBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavouritesBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
