package com.ncidious.ncidious.ui.analytics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.ncidious.ncidious.R


class TestAnalyticsContainerFragment : Fragment() {
    lateinit var analyticsTabLayout:TabLayout
    lateinit var analyticsViewPager:ViewPager2
    lateinit var analyticsFragmentAdapter:AnalyticsFragmentAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_test_analytics_container, container, false)

        analyticsTabLayout=view.findViewById(R.id.analytics_tab_layout)
        analyticsViewPager=view.findViewById(R.id.analytics_view_pager)

        val fragmentManager: FragmentManager = activity!!.supportFragmentManager
        analyticsFragmentAdapter=AnalyticsFragmentAdapter(fragmentManager, lifecycle)

        analyticsViewPager.adapter=analyticsFragmentAdapter

        analyticsTabLayout.addTab(analyticsTabLayout.newTab().setText("Report"))
        analyticsTabLayout.addTab(analyticsTabLayout.newTab().setText("Analytics"))
        analyticsTabLayout.addTab(analyticsTabLayout.newTab().setText("Peer Comparison"))

        analyticsTabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                analyticsViewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        analyticsViewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                analyticsTabLayout.selectTab(analyticsTabLayout.getTabAt(position))
            }
        })


        return view
    }

}