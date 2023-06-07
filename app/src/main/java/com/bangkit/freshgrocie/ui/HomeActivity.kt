package com.bangkit.freshgrocie.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bangkit.freshgrocie.R
import com.bangkit.freshgrocie.databinding.ActivityHomeBinding
import com.bangkit.freshgrocie.fragment.HomeFragment
import com.bangkit.freshgrocie.fragment.ProfileFragment
import com.bangkit.freshgrocie.fragment.StoreFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Toast.makeText(applicationContext,"HELLOO", Toast.LENGTH_SHORT).show()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, HomeFragment() ).commit()
        setupBottomNavigation()
    }
    fun setupBottomNavigation(){
        binding.bottomNavigation.setOnItemSelectedListener { it ->
            when (it.itemId) {
                R.id.itemHome -> {
                    val fragment = HomeFragment()
                    openFragment(fragment)
                }
                R.id.itemDetect -> {
                    val activityCamera = Intent()
                    activityCamera.setClass(applicationContext, CameraActivity::class.java)
                    startActivity(activityCamera)
                }
                R.id.itemStore -> {
                    val fragment = StoreFragment()
                    openFragment(fragment)
                }
                R.id.itemProfile -> {
                    val fragment = ProfileFragment()
                    openFragment(fragment)
                }
            }
            true
        }
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

}