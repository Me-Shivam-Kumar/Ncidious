package com.ncidious.ncidious.ui.analytics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ncidious.ncidious.R
import com.ncidious.ncidious.databinding.FragmentTestOverviewReportBinding

class TestOverviewReportFragment : Fragment() {
    lateinit var testAnalyticsViewModel: TestAnalyticsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentTestOverviewReportBinding= DataBindingUtil.inflate(layoutInflater,R.layout.fragment_test_overview_report,container,false)
        testAnalyticsViewModel= ViewModelProvider(this).get(TestAnalyticsViewModel::class.java)

        testAnalyticsViewModel.getOverallExamAnalysisData().observe(viewLifecycleOwner, Observer{
            binding.marksSecured.text=it.marksSecured.toString()+"/"
            binding.totalMarks.text=it.totalExamMarks.toString()
            binding.questonsAttempted.text=it.attemptedQuestions.toString()+"/"
            binding.totalQuestions.text=it.totalQuestionAvailable.toString()
            binding.timeTaken.text=it.timeTaken.toString()+" hr/"
            binding.totalTimeAvailable.text=it.totalTimeAvailable.toString()+" hr"
            binding.examSpeed.text=(it.attemptedQuestions/it.timeTaken).toString()
            binding.rankSecured.text=it.rankSecured.toString()+"/"
            binding.maxRank.text=it.maxRank.toString()

        })

        return binding.root
    }

}