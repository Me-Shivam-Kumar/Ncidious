package com.ncidious.ncidious.ui.notices

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ncidious.ncidious.data.network.responses.NoticeResponse
import com.ncidious.ncidious.databinding.ItemLayoutNoticeBinding

class NoticesAdapter(private val context: Context,private val noticeList: List<NoticeResponse>):
    RecyclerView.Adapter<NoticesAdapter.BindingViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticesAdapter.BindingViewHolder {
        val rootView = ItemLayoutNoticeBinding.inflate(LayoutInflater.from(context),parent,false)
        return BindingViewHolder(rootView)

    }

    override fun onBindViewHolder(holderBinding: NoticesAdapter.BindingViewHolder, position: Int) {
        val notice:NoticeResponse=noticeList[position]
        holderBinding.noticeItemBinding.noticeItem=notice
        holderBinding.noticeItemBinding.executePendingBindings()
    }

    override fun getItemCount(): Int =noticeList.size

    class BindingViewHolder(val noticeItemBinding: ItemLayoutNoticeBinding):RecyclerView.ViewHolder(noticeItemBinding.root)
}