package com.bangkit.freshgrocie.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bangkit.freshgrocie.ui.ChartActivity
import com.bangkit.freshgrocie.HomeAdapter
import com.bangkit.freshgrocie.R
import com.bangkit.freshgrocie.StoreAdapterHome
import com.bangkit.freshgrocie.databinding.FragmentHomeBinding
import com.bangkit.freshgrocie.ui.DetailProductActivity
import com.bangkit.freshgrocie.ui.MapsActivity
import com.bangkit.freshgrocie.ui.PickLocationActivity
import com.bangkit.freshgrocie.viewmodel.HomeViewModel
import com.bangkit.freshgrocie.viewmodel.HomeViewModelFactory
import com.bangkit.freshgrocie.viewmodel.StoreViewModel
import com.bangkit.freshgrocie.viewmodel.StoreViewModelFactory
import com.google.android.gms.maps.model.LatLng
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView


class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private var latlng: LatLng? = null
    
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
        binding = FragmentHomeBinding.inflate(layoutInflater)
//        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        var db = FirebaseFirestore.getInstance()
        val user = Firebase.auth.currentUser

        val resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    result.data?.let { data ->
                        val address = data.getStringExtra("address")
                        val lat = data.getDoubleExtra("lat", 0.0)
                        val lng = data.getDoubleExtra("lng", 0.0)
                        latlng = LatLng(lat, lng)

                        binding.detailLocation.text = address
                    }
                }
            }

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

            with(binding) {
                searchView.setupWithSearchBar(searchBar)
                binding.idHomeChart.setOnClickListener {
                    startActivity(Intent(context, ChartActivity::class.java))
                    Toast.makeText(activity, "Hello", Toast.LENGTH_SHORT).show()
                }
                binding.nearLocationButton.setOnClickListener {
//                    startActivity(Intent(context, PickLocationActivity::class.java))

                    val intent = Intent(context, PickLocationActivity::class.java)
                    resultLauncher.launch(intent)
                    Toast.makeText(activity, "Hello", Toast.LENGTH_SHORT).show()
                }
                binding.allLocation.setOnClickListener {
                    startActivity(Intent(context, MapsActivity::class.java))
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
                binding.rvProduct.adapter = adapter

                adapter.onItemClick = {
                    val intent = Intent(context, DetailProductActivity::class.java)
                    intent.putExtra("products", it)
                    startActivity(intent)
                }

            }



            return binding.root


        }
    }
