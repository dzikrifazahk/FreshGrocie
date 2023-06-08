package com.bangkit.freshgrocie.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bangkit.freshgrocie.HomeAdapter
import com.bangkit.freshgrocie.R
import com.bangkit.freshgrocie.StoreAdapterHome
import com.bangkit.freshgrocie.databinding.FragmentHomeBinding
import com.bangkit.freshgrocie.viewmodel.HomeViewModel
import com.bangkit.freshgrocie.viewmodel.HomeViewModelFactory
import com.bangkit.freshgrocie.viewmodel.StoreViewModel
import com.bangkit.freshgrocie.viewmodel.StoreViewModelFactory
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView


class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    
    private val viewModel by viewModels<HomeViewModel> {
        HomeViewModelFactory.getInstance(requireActivity())
    }

    private val viewModelStore by viewModels<StoreViewModel> {
        StoreViewModelFactory.getInstance(requireActivity())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        var db = FirebaseFirestore.getInstance()
        val user = Firebase.auth.currentUser

        if (user != null) {
            val docRef: DocumentReference = db.collection("users").document(user.uid)
            docRef.get().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val document = task.result
                    if (document.exists()) {
                        Toast.makeText(view?.context, document.data?.get("user_name").toString(), Toast.LENGTH_SHORT).show()
                        val name = view?.findViewById<TextView>(R.id.tvNameHome)
                        val imageProfile = view?.findViewById<CircleImageView>(R.id.profile_image)

                        name?.text = document.data?.get("user_name").toString()
                        Picasso.get().load(document.data?.get("user_photo").toString()).into(imageProfile);

//                    Log.d(TAG, "DocumentSnapshot data: " + document.data)
                    } else {
                        Toast.makeText(view?.context, "Gagal", Toast.LENGTH_SHORT).show()
//                    Log.d(TAG, "No such document")
                    }

                } else {
                    // No user is signed in
                }
            }
        }

        binding = FragmentHomeBinding.inflate(layoutInflater)

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
            //STORE
            viewModelStore.getStore().observe(viewLifecycleOwner) { list ->
                val adapter = StoreAdapterHome(list)
                Log.d("HomeFragment", adapter.itemCount.toString())
                binding.carouselRecyclerView.setLayoutManager(
                    LinearLayoutManager(
                        requireContext(),
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
                )
                binding.carouselRecyclerView.setHasFixedSize(true);
                binding.carouselRecyclerView.adapter = StoreAdapterHome(list)
                getActivity()?.getViewModelStore()?.clear();
            }

            //PRODUCT
            viewModel.getProduct().observe(viewLifecycleOwner) { list ->
                val adapter = HomeAdapter(list)
                Log.d("HomeFragment", adapter.itemCount.toString())
                binding.rvProduct.setLayoutManager(
                    StaggeredGridLayoutManager(2,
                        StaggeredGridLayoutManager.VERTICAL
                    )
                )
                binding.rvProduct.setHasFixedSize(true);
                binding.rvProduct.adapter = HomeAdapter(list)

            }

//        viewModel.getProduct().observe(viewLifecycleOwner) { list ->
//            val adapter = HomeAdapter(list)
//            Log.d("HomeFragment", adapter.itemCount.toString())
//            binding.rvProduct.setLayoutManager(
//                LinearLayoutManager(
//                    requireContext(),
//                    LinearLayoutManager.VERTICAL,
//                    false
//                )
//            )
//            binding.rvProduct.setHasFixedSize(true);
//            binding.rvProduct.adapter = HomeAdapter(list)
//
//        }
            return binding.root


        }
    }
