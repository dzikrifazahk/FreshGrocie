package com.bangkit.freshgrocie.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.bangkit.freshgrocie.R
import com.bangkit.freshgrocie.databinding.FragmentProfileBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class ProfileFragment : Fragment() {

    private lateinit var binding : FragmentProfileBinding
//    private val viewModel by viewModels<StoreViewModel> {
//        StoreViewModelFactory.getInstance(requireActivity())
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentProfileBinding.inflate(layoutInflater)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
        val view: View = inflater.inflate(R.layout.fragment_profile, container, false)
        val layout: LinearLayout = view.findViewById(R.id.logout)

        layout.setOnClickListener{
            Firebase.auth.signOut()
        }


        }
    }

