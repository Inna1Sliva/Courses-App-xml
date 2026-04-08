package com.it.shka.feature_auth.presentation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.it.shka.feature_auth.R
import com.it.shka.feature_auth.databinding.FragmentAuthBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthFragment : Fragment() {
    private val vm: AuthViewModel by viewModel()
    private var _binding: FragmentAuthBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setupObservers()
        buttonClickListener()
    }

    private fun buttonClickListener() {
        binding.buttonEnter.setOnClickListener {}
        binding.buttonVk.setOnClickListener { vm.openBrowser("https://vk.com/") }
        binding.buttonOk.setOnClickListener { vm.openBrowser("https://ok.ru/") }
    }


    private fun setupObservers() {
        lifecycleScope.launch {
            vm.state.collect { state ->
                binding.buttonEnter.isVisible = state
            }
        }
    }

    private fun setupListeners() {
        binding.mailEdittext.addTextChangedListener { text ->
            vm.onEmailChanged(text.toString())
        }
        binding.passEditText.addTextChangedListener { text ->
            vm.onPasswordChanged(text.toString())
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}