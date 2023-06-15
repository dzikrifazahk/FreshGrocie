package com.bangkit.freshgrocie.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.freshgrocie.R
import com.bangkit.freshgrocie.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView


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
        var db = FirebaseFirestore.getInstance()
        val user = Firebase.auth.currentUser
        val btnLogout: LinearLayout = view.findViewById(R.id.logout)
//        btnLogout = view.findViewById(R.id.logout)

        if (user != null) {
            val docRef: DocumentReference = db.collection("users").document(user.uid)
            docRef.get().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val document = task.result
                    if (document.exists()) {
                        Toast.makeText(
                            view?.context,
                            document.data?.get("user_name").toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                        val name = view?.findViewById<TextView>(R.id.tvNameProfile)
                        val imageProfile = view?.findViewById<CircleImageView>(R.id.profile_image)
                        val email = view?.findViewById<TextView>(R.id.tvEmail)

                        name?.text = document.data?.get("user_name").toString()
                        email?.text = document.data?.get("email").toString()
                        Picasso.get().load(document.data?.get("user_photo").toString())
                            .into(imageProfile);

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

                btnLogout.setOnClickListener {
                    Firebase.auth.signOut()
                    activity?.finish()
                    Toast.makeText(view?.context, "Berhasil Logout", Toast.LENGTH_SHORT).show()

                    println("Logout berhasil")
                }

                return view
            }

    }

