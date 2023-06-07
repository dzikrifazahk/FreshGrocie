package com.bangkit.freshgrocie.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.GridView
import android.widget.ListView
import android.widget.RatingBar
import android.widget.Toast
import com.bangkit.freshgrocie.GVStoreProductAdapter
import com.bangkit.freshgrocie.PhotoboothAdapter
import com.bangkit.freshgrocie.R
import com.bangkit.freshgrocie.viewmodel.GVStoreProduct
import com.smarteist.autoimageslider.SliderView

class StoreDetailActivity : AppCompatActivity() {
    lateinit var imageUrl: ArrayList<String>
    lateinit var sliderView: SliderView
    lateinit var sliderAdapter: PhotoboothAdapter
    lateinit var courseGRV: GridView
    lateinit var courseList: List<GVStoreProduct>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_detail)

        //----------------------------------- For Carosel Upper
        sliderView = findViewById(R.id.photbooth)
        imageUrl = ArrayList()
        imageUrl =
            (imageUrl + "https://practice.geeksforgeeks.org/_next/image?url=https%3A%2F%2Fmedia.geeksforgeeks.org%2Fimg-practice%2Fbanner%2Fdsa-self-paced-thumbnail.png&w=1920&q=75") as ArrayList<String>
        imageUrl =
            (imageUrl + "https://practice.geeksforgeeks.org/_next/image?url=https%3A%2F%2Fmedia.geeksforgeeks.org%2Fimg-practice%2Fbanner%2Fdata-science-live-thumbnail.png&w=1920&q=75") as ArrayList<String>
        imageUrl =
            (imageUrl + "https://practice.geeksforgeeks.org/_next/image?url=https%3A%2F%2Fmedia.geeksforgeeks.org%2Fimg-practice%2Fbanner%2Ffull-stack-node-thumbnail.png&w=1920&q=75") as ArrayList<String>
        sliderAdapter = PhotoboothAdapter( imageUrl)
        sliderView.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
        sliderView.setSliderAdapter(sliderAdapter)
        sliderView.scrollTimeInSec = 3
        sliderView.isAutoCycle = true
        sliderView.startAutoCycle()
        //-----------------------------------


        //----------------------------------- Rating Bar
        val rBar = findViewById<RatingBar>(R.id.ratingbarstore)
        //----------------------------------- GridView Product
        courseGRV = findViewById(R.id.store_product)
        courseList = ArrayList<GVStoreProduct>()
        courseList = courseList + GVStoreProduct("C++", R.drawable.apple_season)
        courseList = courseList + GVStoreProduct("Java", R.drawable.apple_season)
        courseList = courseList + GVStoreProduct("Android", R.drawable.apple_season)
        courseList = courseList + GVStoreProduct("Python", R.drawable.apple_season)
        courseList = courseList + GVStoreProduct("Javascript", R.drawable.apple_season)
        courseList = courseList + GVStoreProduct("Python", R.drawable.apple_season)
        courseList = courseList + GVStoreProduct("Javascript", R.drawable.apple_season)
        courseList = courseList + GVStoreProduct("Python", R.drawable.apple_season)
        courseList = courseList + GVStoreProduct("Javascript", R.drawable.apple_season)
        val courseAdapter = GVStoreProductAdapter(courseList = courseList, this@StoreDetailActivity)
        courseGRV.adapter = courseAdapter
        courseGRV.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                applicationContext, courseList[position].courseName + " selected",
                Toast.LENGTH_SHORT
            ).show()}

    }

}