package com.bangkit.freshgrocie.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.GridView
import android.widget.ImageView
import android.widget.ListView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import com.bangkit.freshgrocie.GVStoreProductAdapter
import com.bangkit.freshgrocie.PhotoboothAdapter
import com.bangkit.freshgrocie.R
import com.bangkit.freshgrocie.database.response.ResponseProductItem
import com.bangkit.freshgrocie.database.response.ResponseStoresItem
import com.bangkit.freshgrocie.databinding.ActivityHomeBinding
import com.bangkit.freshgrocie.databinding.ActivityStoreDetailBinding
import com.bangkit.freshgrocie.viewmodel.GVStoreProduct
import com.bumptech.glide.Glide
import com.smarteist.autoimageslider.SliderView
import org.w3c.dom.Text

class StoreDetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityStoreDetailBinding
    lateinit var imageUrl: ArrayList<String>
    lateinit var sliderView: SliderView
    lateinit var sliderAdapter: PhotoboothAdapter
    lateinit var courseGRV: GridView
    lateinit var courseList: List<GVStoreProduct>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityStoreDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_detail)
        val responsed = intent.getParcelableExtra<ResponseStoresItem>("products")
        if (responsed != null) {
            val StoreName : TextView = binding.dStoreName
            val StoreAdress: TextView = binding.tvStoreCategory
            val StoreDesc: TextView = binding.storeIntro
            val StorePhotoBoot : SliderView = binding.photbooth
            val locationExtra = responsed.storeLocation
            val idExtra = responsed.id

            StoreName.text = responsed.storeName
            StoreDesc.text = responsed.storeDescription
            StoreAdress.text = responsed.storeAddress
            imageUrl = ArrayList()
            imageUrl = (imageUrl + responsed.storePhoto) as ArrayList<String>
            imageUrl = (imageUrl + responsed.storePhoto) as ArrayList<String>
            imageUrl = (imageUrl + responsed.storePhoto) as ArrayList<String>
            sliderAdapter = PhotoboothAdapter(imageUrl)

        }
        //----------------------------------- For Carosel Upper
        sliderView = findViewById(R.id.photbooth)
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