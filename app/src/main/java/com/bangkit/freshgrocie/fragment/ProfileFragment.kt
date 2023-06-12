package com.bangkit.freshgrocie.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.freshgrocie.R
import com.bangkit.freshgrocie.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class ProfileFragment : Fragment() {

    private lateinit var binding : FragmentProfileBinding

//    private val viewModel by viewModels<StoreViewModel> {
//        StoreViewModelFactory.getInstance(requireActivity())
//    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_profile, container, false)

        activity?.window?.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        val btnLogout: LinearLayout = view.findViewById(R.id.logout)
//        btnLogout = view.findViewById(R.id.logout)


        btnLogout.setOnClickListener {
            Firebase.auth.signOut()
            activity?.finish()
            Toast.makeText(view?.context, "Berhasil Logout", Toast.LENGTH_SHORT).show()

            println("Logout berhasil")
        }

        return view

        }
    }

