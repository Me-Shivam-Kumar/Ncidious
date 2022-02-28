package com.ncidious.ncidious.ui.analytics

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class AnalyticsFragmentAdapter : FragmentStateAdapter {
    constructor(fragmentManager: FragmentManager, lifecycle: Lifecycle) : super(
        fragmentManager,
        lifecycle
    )


    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            1 -> TestDetailAnalysisFargment()
            2 -> PeerComparisonFragment()
            else -> TestOverviewReportFragment()
        }
    }
}