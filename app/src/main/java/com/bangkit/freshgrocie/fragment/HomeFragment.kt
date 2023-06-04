package com.bangkit.freshgrocie.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.freshgrocie.HomeAdapter
import com.bangkit.freshgrocie.R
import com.bangkit.freshgrocie.database.datadummy.DataDummy
import com.bangkit.freshgrocie.databinding.ActivityHomeBinding
import com.bangkit.freshgrocie.databinding.FragmentHomeBinding
import com.bangkit.freshgrocie.viewmodel.HomeViewModel
import com.bangkit.freshgrocie.viewmodel.HomeViewModelFactory
import com.google.android.material.carousel.CarouselLayoutManager
import java.util.zip.Inflater

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel> {
        HomeViewModelFactory.getInstance(requireActivity())
    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = FragmentHomeBinding.inflate(layoutInflater)

//        binding.carouselRecyclerView.addItemDecoration(itemDecoration)

//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        viewModel.getProduct().observe(viewLifecycleOwner){ list ->
            val adapter = HomeAdapter(list)
            Log.d("HomeFragment",adapter.itemCount.toString())
            binding.carouselRecyclerView.setLayoutManager(LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false))
            binding.carouselRecyclerView.setHasFixedSize(true);
            binding.carouselRecyclerView.adapter = HomeAdapter(list)

        }

        return binding.root


    }

}