package com.ncidious.ncidious.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ncidious.ncidious.data.network.responses.NoticeResponse
import com.ncidious.ncidious.data.network.responses.PaperAttemptingFormatResponse
import com.ncidious.ncidious.ui.analytics.PaperAttemptingFormatAdapter
import com.ncidious.ncidious.ui.notices.NoticesAdapter

@BindingAdapter("bindPaperAttemptingFormatList")
fun bindPaperAttemptingFormatList(view: RecyclerView, dataList: List<PaperAttemptingFormatResponse>) {
    if (dataList.isEmpty()) {
        return
    }
    var layoutManager = view.layoutManager
    if (layoutManager == null) view.layoutManager = GridLayoutManager(view.context, 2)

    var adapter = view.adapter
    if (adapter == null) {
        adapter = PaperAttemptingFormatAdapter(view.context, dataList)
        view.adapter = adapter
    }
}