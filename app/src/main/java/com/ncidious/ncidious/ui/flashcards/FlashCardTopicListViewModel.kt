package com.ncidious.ncidious.ui.flashcards

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ncidious.ncidious.data.network.responses.FlashCardTopicListResponse
import com.ncidious.ncidious.data.repositories.FlashCardTopicListRepo

class FlashCardTopicListViewModel:ViewModel() {
    private var flashCardTopicList:MutableLiveData<List<FlashCardTopicListResponse>> =
        MutableLiveData<List<FlashCardTopicListResponse>>()

    fun getFlashCardTopicListData(): LiveData<List<FlashCardTopicListResponse>>{
        val flashCardTopic=FlashCardTopicListRepo().getFlashCardTopicList()
        flashCardTopicList.value=flashCardTopic
        return flashCardTopicList
    }

}