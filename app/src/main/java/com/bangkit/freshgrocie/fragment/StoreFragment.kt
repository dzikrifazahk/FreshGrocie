package com.bangkit.freshgrocie.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.freshgrocie.HomeAdapter
import com.bangkit.freshgrocie.R
import com.bangkit.freshgrocie.StoreAdapter
import com.bangkit.freshgrocie.databinding.FragmentHomeBinding
import com.bangkit.freshgrocie.databinding.FragmentStoreBinding
import com.bangkit.freshgrocie.viewmodel.StoreViewModel
import com.bangkit.freshgrocie.viewmodel.StoreViewModelFactory

class StoreFragment : Fragment() {

    private lateinit var binding : FragmentStoreBinding
    private val viewModel by viewModels<StoreViewModel> {
        StoreViewModelFactory.getInstance(requireActivity())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = FragmentStoreBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        viewModel.getStore().observe(viewLifecycleOwner) { list ->
            val adapter = StoreAdapter(list)
            Log.d("StoreFragment", adapter.itemCount.toString())
            binding.rvStoreData.setLayoutManager(
                LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )
            )
            binding.rvStoreData.setHasFixedSize(true);
            binding.rvStoreData.adapter = StoreAdapter(list)
        }
        return binding.root
    }

}