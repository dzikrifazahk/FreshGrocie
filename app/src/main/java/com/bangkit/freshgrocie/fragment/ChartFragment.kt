package com.bangkit.freshgrocie.fragment

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import com.bangkit.freshgrocie.CartAdapter
import com.bangkit.freshgrocie.GVStoreProductAdapter
import com.bangkit.freshgrocie.R
import com.bangkit.freshgrocie.viewmodel.CartModel
import com.bangkit.freshgrocie.viewmodel.GVStoreProduct

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChartFragment : Fragment() {
    lateinit var courseCRV: GridView
    lateinit var handler: Handler
    lateinit var courseList: List<CartModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
<<<<<<< Updated upstream
        activity?.let {
//            toolbarTile = it.findViewById(R.id.homePage_toolbarTitle)
        
//        courseCRV = findViewById(R.id.wish_product)
        courseList = ArrayList<CartModel>()
        courseList = courseList + CartModel("C++",1500,2, R.drawable.apple_season)
        courseList = courseList + CartModel("Java",1500,4, R.drawable.apple_season)
        courseList = courseList + CartModel("Android",1500,5, R.drawable.apple_season)
        courseList = courseList + CartModel("Python",1500,1, R.drawable.apple_season)
        courseList = courseList + CartModel("Javascript",1500,3, R.drawable.apple_season)
=======
//        activity?.let {
//            toolbarTile = it.findViewById(R.id.homePage_toolbarTitle)
//        }
//        courseCRV = findViewById(R.id.wish_product)
//        courseList = ArrayList<CartModel>()
//        courseList = courseList + CartModel("C++",1500,2, R.drawable.apple_season)
//        courseList = courseList + CartModel("Java",1500,4, R.drawable.apple_season)
//        courseList = courseList + CartModel("Android",1500,5, R.drawable.apple_season)
//        courseList = courseList + CartModel("Python",1500,1, R.drawable.apple_season)
//        courseList = courseList + CartModel("Javascript",1500,3, R.drawable.apple_season)
>>>>>>> Stashed changes
//        val courseAdapter = CartAdapter(courseList = courseList, this@ChartFragment)
//        courseCRV.adapter = courseAdapter
//        courseCRV.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
//            Toast.makeText(
//                applicationContext, courseList[position].courseName + " selected",
//                Toast.LENGTH_SHORT
//            ).show()
<<<<<<< Updated upstream
        }
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
=======
//        }

>>>>>>> Stashed changes
    }

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_chart, container, false)
//    }

