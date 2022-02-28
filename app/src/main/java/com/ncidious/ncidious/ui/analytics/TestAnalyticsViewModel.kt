package com.ncidious.ncidious.ui.analytics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ncidious.ncidious.data.network.responses.*
import com.ncidious.ncidious.data.repositories.TestAnalaysisRepository

class TestAnalyticsViewModel: ViewModel() {

    private var timeAnalysisData: MutableLiveData<TimeAnalysisResponse> =MutableLiveData()
    private var subjectWiseTimeDistribution:MutableLiveData<SubjectWiseTimeDistribution> =MutableLiveData()
    private var paperAttemptingFormat:MutableLiveData<List<PaperAttemptingFormatResponse>> =MutableLiveData()
    private var barChartResponseScoreInPercentage:MutableLiveData<BarChartResponse> =MutableLiveData()
    private var negativeMarksLiveData:MutableLiveData<BarChartResponse> =MutableLiveData()
    private var overallExamAnalysisData:MutableLiveData<OverallExamAnalysisResponse> =MutableLiveData()


    fun getTimeAnalysisData(): LiveData<TimeAnalysisResponse>{
        timeAnalysisData.value=TestAnalaysisRepository().getTestAnalysis().timeAnalysisResponse
        return timeAnalysisData
    }
    fun getSubjectWiseTimeDistribution():LiveData<SubjectWiseTimeDistribution>{
        subjectWiseTimeDistribution.value=TestAnalaysisRepository().getTestAnalysis().subjectWiseTimeAnalysis
        return subjectWiseTimeDistribution
    }
    fun getPaperAttemptingFormat():LiveData<List<PaperAttemptingFormatResponse>>{
        paperAttemptingFormat.value=TestAnalaysisRepository().getTestAnalysis().paperAttemptingFormat
        return paperAttemptingFormat
    }
    fun getScoreInPercentage():LiveData<BarChartResponse>{
        barChartResponseScoreInPercentage.value=TestAnalaysisRepository().getTestAnalysis().scoreInPercentageData
        return barChartResponseScoreInPercentage
    }
    fun getNegativeMarksData():LiveData<BarChartResponse>{
        negativeMarksLiveData.value=TestAnalaysisRepository().getTestAnalysis().negativeMarksData
        return negativeMarksLiveData
    }

    fun getOverallExamAnalysisData():LiveData<OverallExamAnalysisResponse>{
        overallExamAnalysisData.value= TestAnalaysisRepository().getTestAnalysis().overallExamAnalysisData
        return overallExamAnalysisData
    }

}