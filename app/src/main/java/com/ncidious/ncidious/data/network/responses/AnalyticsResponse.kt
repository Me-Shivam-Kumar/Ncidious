package com.ncidious.ncidious.data.network.responses

data class AnalyticsResponse(
    val timeAnalysisResponse: TimeAnalysisResponse,
    val subjectWiseTimeAnalysis:SubjectWiseTimeDistribution,
    val paperAttemptingFormat:List<PaperAttemptingFormatResponse>,
    val scoreInPercentageData:BarChartResponse,
    val negativeMarksData:BarChartResponse,
    val overallExamAnalysisData:OverallExamAnalysisResponse
)