package com.ncidious.ncidious.ui.analytics

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ncidious.ncidious.data.network.responses.PaperAttemptingFormatResponse
import com.ncidious.ncidious.databinding.ItemLayoutPaperAttemptingformatBinding

class PaperAttemptingFormatAdapter(private val context: Context,private val dataList:List<PaperAttemptingFormatResponse>):
    RecyclerView.Adapter<PaperAttemptingFormatAdapter.BindingViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val rootView = ItemLayoutPaperAttemptingformatBinding.inflate(LayoutInflater.from(context),parent, false)
        return BindingViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        val paperAttemptingFormatItem:PaperAttemptingFormatResponse=dataList[position]
        holder.paperAttemptingFormatItemBinding.paperAttemptingFormatItem=paperAttemptingFormatItem
        holder.indexView.text= (position + 1).toString()
        holder.paperAttemptingFormatItemBinding.executePendingBindings()
    }

    override fun getItemCount(): Int = dataList.size
    class BindingViewHolder(val paperAttemptingFormatItemBinding:ItemLayoutPaperAttemptingformatBinding):RecyclerView.ViewHolder(paperAttemptingFormatItemBinding.root){
        var indexView=paperAttemptingFormatItemBinding.index

    }
}