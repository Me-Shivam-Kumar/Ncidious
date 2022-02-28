package com.ncidious.ncidious.data.network.responses

data class ComplexityWiseAnalysisResponse(
    val subjectTitle:String,
    val correctAnsweredEasyQuestions:String,
    val wrongAnsweredEasyQuestion:String,
    val correctAnsweredMediumQuestions:String,
    val wrongAnsweredMediumQuestion:String,
    val correctAnsweredHardQuestions:String,
    val wrongAnsweredHardQuestion:String,
    val totalEasyQuestion:String,
    val totalMediumQuestion:String,
    val totalHardQuestion:String

)