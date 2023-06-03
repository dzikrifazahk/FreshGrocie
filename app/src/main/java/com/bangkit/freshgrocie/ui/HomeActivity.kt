package com.bangkit.freshgrocie.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.bangkit.freshgrocie.fragment.OnboardingFragment
import com.bangkit.freshgrocie.R


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        PreferenceManager.getDefaultSharedPreferences(this).apply {
//            if (!getBoolean(OnboardingFragment.COMPLETED_ONBOARDING_PREF_NAME, false)) {
//                startActivity(Intent(this@HomeActivity, StoreActivity::class.java))
//            }
//        }
        setContentView(R.layout.activity_user_register)
//        startActivity(Intent(this@HomeActivity, HomeActivity::class.java))
//        startActivity(Intent(this@HomeActivity, HomeActivity::class.java))

    }
}
