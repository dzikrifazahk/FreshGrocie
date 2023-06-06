package com.bangkit.freshgrocie

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bangkit.freshgrocie.fragment.CanceledFragment
import com.bangkit.freshgrocie.fragment.CompleteFragment
import com.bangkit.freshgrocie.fragment.OngoingFragment

class TabTransactionAdapter (activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = OngoingFragment()
            1 -> fragment = CompleteFragment()
            2 -> fragment = CanceledFragment()
        }
        return fragment as Fragment
    }

}