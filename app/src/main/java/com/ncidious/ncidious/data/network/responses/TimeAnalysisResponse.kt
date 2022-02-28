package com.ncidious.ncidious.data.network.responses

data class TimeAnalysisResponse(
    val correctAnsweredQuestion:String,
    val wrongAnsweredQuestion:String,
    val notAnsweredQuestions:String
)