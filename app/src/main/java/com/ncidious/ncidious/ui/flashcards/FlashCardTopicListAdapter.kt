package com.ncidious.ncidious.ui.flashcards

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ncidious.ncidious.BR
import com.ncidious.ncidious.data.network.responses.FlashCardTopicListResponse
import com.ncidious.ncidious.databinding.ItemLayoutFlashCardBinding

class FlashCardTopicListAdapter(private val context: Context,private val topicList:List<FlashCardTopicListResponse>):
    RecyclerView.Adapter<FlashCardTopicListAdapter.BindingViewHolder> (){


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FlashCardTopicListAdapter.BindingViewHolder {
       val rootView=ItemLayoutFlashCardBinding.inflate(LayoutInflater.from(context),parent,false)
        return BindingViewHolder(rootView)
    }

    override fun onBindViewHolder(
        holder: FlashCardTopicListAdapter.BindingViewHolder,
        position: Int
    ) {
       val flashCardData:FlashCardTopicListResponse=topicList[position]
        holder.flashCardTopicListItemBinding.flashCardTopicItem=flashCardData
        holder.flashCardTopicListItemBinding.setVariable(BR.clickListnener,context as IFlashCardActivity)
        holder.flashCardTopicListItemBinding.executePendingBindings()
    }

    override fun getItemCount(): Int =topicList.size
    class BindingViewHolder(val flashCardTopicListItemBinding:ItemLayoutFlashCardBinding):RecyclerView.ViewHolder(flashCardTopicListItemBinding.root){
    }
}