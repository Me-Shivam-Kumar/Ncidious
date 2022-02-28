package com.ncidious.ncidious.data.network.responses

data class QuestionResponse(
    var question: String? = null,
    var optionA: String? = null,
    var optionB: String? = null,
    var optionC: String? = null,
    var optionD: String? = null,
    var questionImage: Int = 0,
    var optionA_Image: Int = 0,
    var optionB_Image: Int = 0,
    var optionC_Image: Int = 0,
    var optionD_Image: Int = 0,
    var timeLimit: Int = 0,
    var questionsCount: Int = 0,
    var positiveMarks: Int = 0,
    var negativeMarks: Int = 0,
    var correct_options: IntArray? = intArrayOf()
)