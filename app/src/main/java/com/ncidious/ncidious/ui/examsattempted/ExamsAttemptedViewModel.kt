package com.ncidious.ncidious.ui.examsattempted

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ncidious.ncidious.data.network.responses.ExamsAttemptedResponse
import com.ncidious.ncidious.data.repositories.ExamAttemptedRepository

class ExamsAttemptedViewModel: ViewModel() {
    private var examsAttemptedList:MutableLiveData<List<ExamsAttemptedResponse>> = MutableLiveData<List<ExamsAttemptedResponse>>()


    fun getExamsAttemptedListData(): LiveData<List<ExamsAttemptedResponse>>{
        examsAttemptedList.value=ExamAttemptedRepository().getExamAttemptedList()

        return examsAttemptedList
    }

}