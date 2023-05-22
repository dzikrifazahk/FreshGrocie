package com.bangkit.freshgrocie

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PreferenceManager.getDefaultSharedPreferences(this).apply {
            if (getBoolean(OnboardingFragment.COMPLETED_ONBOARDING_PREF_NAME, false)) {
                startActivity(Intent(this@MainActivity, OnboardingActivity::class.java))
            }
        }
    }

}
