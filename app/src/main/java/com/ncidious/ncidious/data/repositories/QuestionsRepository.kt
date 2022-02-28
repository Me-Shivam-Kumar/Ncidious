package com.ncidious.ncidious.data.repositories

import com.ncidious.ncidious.R
import com.ncidious.ncidious.data.network.responses.QuestionResponse
import java.util.*

class QuestionsRepository {
    private lateinit var questionsModelList:List<QuestionResponse>

    fun getQuestionsList() :List<QuestionResponse>{
        questionsModelList = ArrayList<QuestionResponse>()
        val correct_answer = intArrayOf(1, 0, 0, 0)
        (questionsModelList as ArrayList<QuestionResponse>).add(
            QuestionResponse(
                "What is your name",
                "Shivam",
                "Khushi",
                "Ritik",
                "Manish",
                R.drawable.cpu,
                0,
                0,
                R.drawable.organic_chemistry,
                R.drawable.newtons_cradle,
                30,
                10,
                4,
                -2,
                correct_answer
            )
        )
        (questionsModelList as ArrayList<QuestionResponse>).add(
            QuestionResponse(
                "What is your ",
                "Shivam",
                "Khushi",
                "Ritik",
                "Manish",
                R.drawable.cpu,
                0,
                0,
                R.drawable.organic_chemistry,
                R.drawable.newtons_cradle,
                30,
                10,
                4,
                -2,
                correct_answer
            )
        )
        (questionsModelList as ArrayList<QuestionResponse>).add(
            QuestionResponse(
                "What is",
                "Shivam",
                "Khushi",
                "Ritik",
                "Manish",
                R.drawable.cpu,
                0,
                0,
                R.drawable.organic_chemistry,
                R.drawable.newtons_cradle,
                30,
                10,
                4,
                -2,
                correct_answer
            )
        )
      return questionsModelList
    }


}