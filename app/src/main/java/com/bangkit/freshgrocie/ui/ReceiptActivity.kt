package com.bangkit.freshgrocie.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit.freshgrocie.R
import com.bangkit.freshgrocie.databinding.ActivityReceiptBinding

class ReceiptActivity : AppCompatActivity() {
    private lateinit var binding : ActivityReceiptBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceiptBinding.inflate(layoutInflater)

        binding.backButton.setOnClickListener {
            startActivity(Intent(applicationContext, CameraActivity::class.java))
        }
        
        setContentView(binding.root)
    }
}