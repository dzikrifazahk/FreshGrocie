package com.bangkit.freshgrocie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.preference.PreferenceManager
import com.bangkit.freshgrocie.databinding.ActivityOnboardingFinishBinding

class OnboardingFinish : AppCompatActivity() {
    private lateinit var btnStart: LinearLayout

    private lateinit var binding: ActivityOnboardingFinishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingFinishBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        btnStart = binding.layoutStart
        btnStart.setOnClickListener {
            PreferenceManager.getDefaultSharedPreferences(this).edit().apply {
                putBoolean(OnboardingFragment.COMPLETED_ONBOARDING_PREF_NAME, true)
                apply()
            }
            finish()
        }
    }
}