package com.ncidious.ncidious.ui.analytics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.ncidious.ncidious.R
import com.ncidious.ncidious.databinding.FragmentPeerComparisonBinding


class PeerComparisonFragment : Fragment() {
    lateinit var testAnalyticsViewModel:TestAnalyticsViewModel
    var sccoreInPercentageDataList:ArrayList<BarChartModel> =ArrayList()
    var negativeMarksDataList:ArrayList<BarChartModel> =ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentPeerComparisonBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_peer_comparison,
            container,
            false
        )
        testAnalyticsViewModel= ViewModelProvider(this).get(TestAnalyticsViewModel::class.java)

        testAnalyticsViewModel.getScoreInPercentage().observe(viewLifecycleOwner, Observer {
            fillData(it.dataList, sccoreInPercentageDataList)
            prepareBarChart(sccoreInPercentageDataList,"Score (in %age, along Y-axis) (-ve scores are shown as 0%)",binding.scoreInPercentageChart)
        })

        testAnalyticsViewModel.getNegativeMarksData().observe(viewLifecycleOwner, Observer{
            fillData(it.dataList,negativeMarksDataList)
            prepareBarChart(negativeMarksDataList,"Negative Marks(along Y-axis)",binding.negativeMarksChart)
        })
        return binding.root

    }
    fun fillData(dataList: List<List<String>>, dataContainerList: ArrayList<BarChartModel>){
        dataContainerList.clear()
        val size:Int = dataList.size
        for (i in 0 until size) {
            dataContainerList.add(BarChartModel(dataList[i][0], Integer.parseInt(dataList[i][1])))
        }
    }
    private fun prepareBarChart(
        barChartModelList: java.util.ArrayList<BarChartModel>,
        graphTitle: String,
        chartId: BarChart
    ) {
        var scoreEntry = java.util.ArrayList<BarEntry>()
        var labelNames = java.util.ArrayList<String>()
        scoreEntry.clear()
        labelNames.clear()
        for (i in barChartModelList.indices) {
            val studentType: String = barChartModelList[i].studentType
            val scorePercentage: Int = barChartModelList[i].marksPercentage
            scoreEntry.add(BarEntry(i.toFloat(), scorePercentage.toFloat()))
            labelNames.add(studentType)
        }
        val dataSet = BarDataSet(scoreEntry, graphTitle)
        dataSet.setColors(*ColorTemplate.MATERIAL_COLORS)
        val description = Description()
        description.text = ""
        chartId.description = description
        val barData = BarData(dataSet)
        chartId.data = barData
        val xAxis = chartId.xAxis
        xAxis.valueFormatter = IndexAxisValueFormatter(labelNames)
        xAxis.position = XAxis.XAxisPosition.TOP
        xAxis.setDrawGridLines(false)
        xAxis.setDrawAxisLine(false)
        xAxis.granularity = 1f
        xAxis.labelCount = 3
        chartId.animateY(1000)
        chartId.invalidate()
    }

}