package com.ncidious.ncidious.data.network.responses

data class OverallExamAnalysisResponse(
    val marksSecured:Int,
    val totalExamMarks:Int,
    val attemptedQuestions:Int,
    val totalQuestionAvailable:Int,
    val timeTaken:Int,
    val totalTimeAvailable:Int,
    val rankSecured:Int,
    val maxRank:Int
)