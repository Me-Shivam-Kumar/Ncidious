package com.ncidious.ncidious.ui.analytics

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.ncidious.ncidious.R
import com.ncidious.ncidious.data.network.responses.SubjectWiseTimeDistribution
import com.ncidious.ncidious.data.network.responses.TimeAnalysisResponse
import com.ncidious.ncidious.databinding.FragmentTestDetailAnalysisFargmentBinding
import java.util.*

class TestDetailAnalysisFargment : Fragment() {
    lateinit var subjectWiseTimeDistributionPieChart:PieChart
    lateinit var testAnalyticsViewModel: TestAnalyticsViewModel
     var timeAnalysisData:TimeAnalysisResponse=TimeAnalysisResponse("0","0","0")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentTestDetailAnalysisFargmentBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_test_detail_analysis_fargment,
            container,
            false
        )
        testAnalyticsViewModel= ViewModelProvider(this).get(TestAnalyticsViewModel::class.java)
        testAnalyticsViewModel.getTimeAnalysisData().observe(viewLifecycleOwner, Observer {
            timeAnalysisData = it
            setupPieChart(binding.timeDistributionPieChart,"Time Analysis")
            val correctQuestionAttemptedTime=(timeAnalysisData.correctAnsweredQuestion)
            val wrongQuestionAttemptedTime=timeAnalysisData.wrongAnsweredQuestion
            val notAttemptedQuestionTime=timeAnalysisData.notAnsweredQuestions
            val c= (correctQuestionAttemptedTime.toFloat()/100)
            val w= (wrongQuestionAttemptedTime.toFloat()/100)
            val n= (notAttemptedQuestionTime.toFloat()/100)
            loadPieChartData(binding.timeDistributionPieChart,c,w,n,"Correct Answered Que","Unattemped Que","Wrong Answered Que")
        })
        testAnalyticsViewModel.getSubjectWiseTimeDistribution().observe(viewLifecycleOwner, Observer {
            setupPieChart(binding.subjectWiseTimeDistributionPieChart,"Subject Wise Time Distribution")
            val timeTakenInPhysics=it.timeTakenInPhysics.toFloat()/100
            val timeTakenInMaths=it.timeTakenInMaths.toFloat()/100
            val timeTakenInChemistry=it.timetakenInChemistry.toFloat()/100
            loadPieChartData(binding.subjectWiseTimeDistributionPieChart,timeTakenInPhysics,timeTakenInMaths,timeTakenInChemistry,"Pysics","Maths","Chemistry")
        })
        subjectWiseTimeDistributionPieChart=binding.subjectWiseTimeDistributionPieChart

        testAnalyticsViewModel.getPaperAttemptingFormat().observe(viewLifecycleOwner,Observer {
            binding.paperAttemptingFormatList=it
        })
        return binding.root


    }

    private fun setupPieChart(pieChart:PieChart,centerText:String) {
        pieChart.setDrawHoleEnabled(true)
        pieChart.setUsePercentValues(true)
        pieChart.setEntryLabelTextSize(0f)
        pieChart.setEntryLabelColor(Color.BLACK)
        pieChart.setCenterText(centerText)
        pieChart.setCenterTextSize(15f)
        pieChart.getDescription().setEnabled(false)
        val legend: Legend = pieChart.getLegend()
        legend.verticalAlignment = Legend.LegendVerticalAlignment.TOP
        legend.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
        legend.orientation = Legend.LegendOrientation.VERTICAL
        legend.setDrawInside(false)
        legend.isEnabled = true
    }
    private fun loadPieChartData(pieChart:PieChart,value1:Float,value2: Float,value3:Float,value1Title:String,value2Title:String,value3Title:String) {

        val pieEntries = ArrayList<PieEntry>()
        pieEntries.add(PieEntry(value1, value1Title))
        pieEntries.add(PieEntry(value2, value2Title))
        pieEntries.add(PieEntry(value3, value3Title))
        val colors = ArrayList<Int>()
        for (color in ColorTemplate.MATERIAL_COLORS) {
            colors.add(color)
        }
        val dataset = PieDataSet(pieEntries, "")
        if(pieChart==subjectWiseTimeDistributionPieChart){
            colors.removeAt(2)
        }
        dataset.colors = colors
        val pieData = PieData(dataset)
        pieData.setDrawValues(true)
        pieData.setValueFormatter(PercentFormatter(pieChart))
        pieData.setValueTextSize(8f)
        pieData.setValueTextColor(Color.BLACK)
        pieChart.setData(pieData)
        pieChart.invalidate()
        pieChart.animateY(1400, Easing.EaseInOutQuad)
    }

}