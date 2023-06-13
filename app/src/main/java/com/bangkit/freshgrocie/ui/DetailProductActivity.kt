package com.bangkit.freshgrocie.ui

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.freshgrocie.R
import com.bangkit.freshgrocie.database.response.ResponseProductItem
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso


class DetailProductActivity : AppCompatActivity() {
    //    lateinit var imageUrl: ArrayList<String>
//    lateinit var sliderView: SliderView
//    lateinit var sliderAdapter: PhotoboothAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)

        val responsed = intent.getParcelableExtra<ResponseProductItem>("products")
        if (responsed != null) {
            val productName: TextView = findViewById(R.id.tvProductName)
            val productCategory: TextView = findViewById(R.id.tvProductCategory)
            val productDesc: TextView = findViewById(R.id.productDescription)
            val imageView : ImageView = findViewById(R.id.image)

            productName.text = responsed.productName
            productCategory.text = responsed.productCategory
            productDesc.text = responsed.productDescription

            Glide.with(baseContext)
                .load(responsed.productPhoto)
                .centerCrop()
                .into(imageView)
        }

        val backButton:ImageView = findViewById(R.id.backButtonDetail)
        backButton.setOnClickListener {
            startActivity(Intent(applicationContext, HomeActivity::class.java))
        }
    }
}