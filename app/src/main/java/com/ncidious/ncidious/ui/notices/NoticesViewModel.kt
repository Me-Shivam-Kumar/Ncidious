package com.ncidious.ncidious.ui.notices

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ncidious.ncidious.data.network.responses.NoticeResponse
import com.ncidious.ncidious.data.repositories.NoticeRepository


import com.ncidious.ncidious.util.ApiException
import com.ncidious.ncidious.util.Coroutines

class NoticesViewModel: ViewModel() {
    private var noticesLiveData: MutableLiveData<List<NoticeResponse>> = MutableLiveData<List<NoticeResponse>>()

    fun getNoticesListData(): LiveData<List<NoticeResponse>> {
        return noticesLiveData
    }
    suspend fun getNoticesListFromRepp(){
        noticesLiveData.setValue(NoticeRepository().getNotices())
    }

}