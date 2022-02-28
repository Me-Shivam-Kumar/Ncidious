package com.ncidious.ncidious.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ncidious.ncidious.data.network.responses.ExamsAttemptedResponse
import com.ncidious.ncidious.ui.examsattempted.ExamsAttemptedAdapter

@BindingAdapter("bindExamAttemptedList")
fun bindRecyclerViewList(view: RecyclerView, examAttemptedList: List<ExamsAttemptedResponse>) {
    if (examAttemptedList.isEmpty()) {
        return
    }
    var layoutManager = view.layoutManager
    if (layoutManager == null) view.layoutManager =
        LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)


    var adapter = view.adapter
    if (adapter == null) {
        adapter = ExamsAttemptedAdapter(view.context, examAttemptedList)
        view.adapter = adapter
    }
}