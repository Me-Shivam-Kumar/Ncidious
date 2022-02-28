package com.ncidious.ncidious.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ncidious.ncidious.data.network.responses.FlashCardTopicListResponse
import com.ncidious.ncidious.ui.flashcards.FlashCardTopicListAdapter

@BindingAdapter("bindFlashCardList")
fun bindFlashCardTopicList(
    view: RecyclerView,
    flashCardTopicList: List<FlashCardTopicListResponse>
) {
    if (flashCardTopicList.isEmpty()) {
        return
    }
    var layoutManager = view.layoutManager
    if (layoutManager == null) view.layoutManager =
        LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
    var adapter = view.adapter
    if (adapter == null) {
        adapter = FlashCardTopicListAdapter(view.context, flashCardTopicList)
        view.adapter = adapter
    }
}