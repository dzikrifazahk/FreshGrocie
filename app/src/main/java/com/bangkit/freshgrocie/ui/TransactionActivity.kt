package com.bangkit.freshgrocie.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.viewpager2.widget.ViewPager2
import com.bangkit.freshgrocie.R
import com.bangkit.freshgrocie.TabTransactionAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TransactionActivity : AppCompatActivity() {
    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab1,
            R.string.tab2,
            R.string.tab3
        )
        @DrawableRes
        private val TAB_ICON = intArrayOf(
            R.drawable.on_going_icon,
            R.drawable.completed_icon,
            R.drawable.canceled_icon
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction)
        val sectionsPagerAdapter = TabTransactionAdapter(this)
        val viewPager: ViewPager2 = findViewById(R.id.transcation_view_layout)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabT_layout)
        TabLayoutMediator(tabs, viewPager) { tab, position->
            tab.text = resources.getString(TAB_TITLES[position])
            tab.icon = resources.getDrawable(TAB_ICON[position])
        }.attach()
    }
}