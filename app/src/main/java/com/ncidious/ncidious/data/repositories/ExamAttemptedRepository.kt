package com.ncidious.ncidious.data.repositories

import com.ncidious.ncidious.data.network.responses.ExamsAttemptedResponse

class ExamAttemptedRepository {
    private lateinit var examAttemptedList: List<ExamsAttemptedResponse>

    fun getExamAttemptedList(): List<ExamsAttemptedResponse> {
        examAttemptedList=ArrayList<ExamsAttemptedResponse>()
        (examAttemptedList as ArrayList<ExamsAttemptedResponse>).add(
            ExamsAttemptedResponse(
                "Jee Advanced", "12/4/2021","5","230","300"
            )
        )
        (examAttemptedList as ArrayList<ExamsAttemptedResponse>).add(
            ExamsAttemptedResponse(
                "Jee Mains", "12/4/2021","5","180","300"
            )
        )
        (examAttemptedList as ArrayList<ExamsAttemptedResponse>).add(
            ExamsAttemptedResponse(
                "Jee Advanced+Jee Mains", "12/4/2021","5","270","300"
            )
        )


        return examAttemptedList
    }
}