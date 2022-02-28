package com.ncidious.ncidious.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ncidious.ncidious.data.network.responses.ExamsAttemptedResponse
import com.ncidious.ncidious.data.network.responses.FlashCardTopicListResponse
import com.ncidious.ncidious.data.network.responses.NoticeResponse
import com.ncidious.ncidious.ui.examsattempted.ExamsAttemptedAdapter
import com.ncidious.ncidious.ui.flashcards.FlashCardTopicListAdapter
import com.ncidious.ncidious.ui.notices.NoticesAdapter

@BindingAdapter("bindDataList")
fun bindRecyclerViewList(view: RecyclerView, dataList: List<NoticeResponse>) {
    if (dataList.isEmpty()) {
        return
    }
    var layoutManager = view.layoutManager
    if (layoutManager == null) view.layoutManager = GridLayoutManager(view.context, 2)

    var adapter = view.adapter
    if (adapter == null) {
        adapter = NoticesAdapter(view.context, dataList)
        view.adapter = adapter
    }
}