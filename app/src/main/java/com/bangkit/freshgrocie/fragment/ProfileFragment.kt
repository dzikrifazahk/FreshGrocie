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
import com.bangkit.freshgrocie.databinding.FragmentHomeBinding
import com.bangkit.freshgrocie.databinding.FragmentProfileBinding
import com.bangkit.freshgrocie.databinding.FragmentStoreBinding
import com.bangkit.freshgrocie.viewmodel.HomeViewModel
import com.bangkit.freshgrocie.viewmodel.HomeViewModelFactory
import com.bangkit.freshgrocie.viewmodel.StoreViewModel
import com.bangkit.freshgrocie.viewmodel.StoreViewModelFactory

class ProfileFragment : Fragment() {

    private lateinit var binding : FragmentProfileBinding
//    private val viewModel by viewModels<StoreViewModel> {
//        StoreViewModelFactory.getInstance(requireActivity())
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)

        }
    }

