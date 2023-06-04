package com.bangkit.freshgrocie.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.bangkit.freshgrocie.R
import com.bangkit.freshgrocie.databinding.ActivityHomeBinding
import com.bangkit.freshgrocie.fragment.HomeFragment
import com.bangkit.freshgrocie.fragment.StoreFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    private lateinit var bottomNavigation : BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_home)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//        PreferenceManager.getDefaultSharedPreferences(this).apply {
//            if (!getBoolean(OnboardingFragment.COMPLETED_ONBOARDING_PREF_NAME, false)) {
//                startActivity(Intent(this@HomeActivity, StoreActivity::class.java))
//            }
//        }
//        startActivity(Intent(this@HomeActivity, HomeActivity::class.java))
//        startActivity(Intent(this@HomeActivity, HomeActivity::class.java))
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, HomeFragment() ).commit()
        setupBottomNavigation()
    }

     fun setupBottomNavigation(){
        binding.bottomNavigation.setOnItemSelectedListener { it ->
            when (it) {
                R.id.itemHome -> {
                    val fragment = HomeFragment()
                    openFragment(fragment)
                }
                R.id.itemStore -> {
                    val fragment = StoreFragment()
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
