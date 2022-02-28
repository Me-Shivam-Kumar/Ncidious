package com.ncidious.ncidious.data.repositories

import com.ncidious.ncidious.data.network.responses.*

class TestAnalaysisRepository {

    fun getTestAnalysis():AnalyticsResponse{
        return AnalyticsResponse(TimeAnalysisResponse("40","50","10"),
            SubjectWiseTimeDistribution(20,50,30),
            listOf<PaperAttemptingFormatResponse>(PaperAttemptingFormatResponse("Physics MCQ"),PaperAttemptingFormatResponse("Physics Num"),
                PaperAttemptingFormatResponse("Maths MCQ"),PaperAttemptingFormatResponse("Chemistry MCQ"),PaperAttemptingFormatResponse("Physics MCQ"),
            ),
            BarChartResponse(listOf(listOf("Topper","100"),listOf("Yours","45"),listOf("Avg.","37"))),
            BarChartResponse(listOf(listOf("Max","85"),listOf("Min","2"),listOf("Yours.","35"),listOf("Avg.","40"))),
            OverallExamAnalysisResponse(180,300,60,75,3,3,7,100)
        )
    }
}