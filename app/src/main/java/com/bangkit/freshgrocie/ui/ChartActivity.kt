package com.bangkit.freshgrocie.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bangkit.freshgrocie.R

class ChartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)


        val backBtn:ImageView = findViewById(R.id.backButton)
            backBtn.setOnClickListener {
                startActivity(Intent(applicationContext, HomeActivity::class.java))
            }
        }

    }
