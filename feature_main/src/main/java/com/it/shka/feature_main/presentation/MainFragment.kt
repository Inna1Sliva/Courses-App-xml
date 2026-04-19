package com.it.shka.feature_main.presentation

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.Visibility
import com.it.shka.feature_main.databinding.FragmentMainBinding
import com.it.shka.feature_main.domain.model.Courses
import com.it.shka.feature_main.presentation.adapter.CoursesAdapter
import com.it.shka.feature_main.presentation.model.CoursesState
import com.it.shka.feature_main.presentation.model.MainViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.getValue

class MainFragment : Fragment() {
    private val vm: MainViewModel by viewModel()
    lateinit var adapter: CoursesAdapter
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupButtonListener()
        lifecycleScope.launch {
            vm.coursesState.collect { state ->
                when (state) {
                    is CoursesState.Loading -> {
                        binding.progressCircular.visibility = View.VISIBLE
                        binding.coursesRecyclerView.visibility = View.GONE
                    }

                    is CoursesState.getCourses -> {
                        binding.progressCircular.visibility = View.GONE
                        binding.coursesRecyclerView.visibility = View.VISIBLE
                        setupRecyclerView(state.courses)
                    }
                }

            }
        }


    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setupButtonListener() {
        binding.buttTextSorting.setOnClickListener {
            vm.sortInDescendingOrder()
        }
    }


    private fun setupRecyclerView(courses: List<Courses>) {
        binding.coursesRecyclerView.layoutManager = LinearLayoutManager(requireActivity())
        adapter = CoursesAdapter(courses, requireActivity())
        binding.coursesRecyclerView.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}