package com.bangkit.freshgrocie.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.freshgrocie.HomeAdapter
import com.bangkit.freshgrocie.databinding.FragmentHomeBinding
import com.bangkit.freshgrocie.viewmodel.HomeViewModel
import com.bangkit.freshgrocie.viewmodel.HomeViewModelFactory

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel> {
        HomeViewModelFactory.getInstance(requireActivity())
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater)
        val binding = FragmentHomeBinding.inflate(inflater, container, false)

        with(binding) {
            searchView.setupWithSearchBar(searchBar)
            binding.idHomeChart.setOnClickListener {
                Toast.makeText(activity, "Hello", Toast.LENGTH_SHORT).show()
                startActivity(Intent(context, ChartFragment::class.java))
            }
            binding.elevatedButton.setOnClickListener {
                Toast.makeText(activity, "Hello", Toast.LENGTH_SHORT).show()
            }
        }
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