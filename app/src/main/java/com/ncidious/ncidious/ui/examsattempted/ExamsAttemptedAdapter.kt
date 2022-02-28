package com.ncidious.ncidious.ui.examsattempted

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ncidious.ncidious.BR
import com.ncidious.ncidious.data.network.responses.ExamsAttemptedResponse
import com.ncidious.ncidious.databinding.ItemLayoutExamsAttemptedBinding
import com.ncidious.ncidious.ui.analytics.IAnalyticsCall


class ExamsAttemptedAdapter(
    private val context: Context,
    private val dataList: List<ExamsAttemptedResponse>
) :
    RecyclerView.Adapter<ExamsAttemptedAdapter.BindingViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val rootView =
            ItemLayoutExamsAttemptedBinding.inflate(LayoutInflater.from(context), parent, false)
        return BindingViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        val examsAttempted: ExamsAttemptedResponse = dataList[position]
        holder.examAttemptedItemBinding.examsAttempted = examsAttempted
        holder.examAttemptedItemBinding.setVariable(BR.attemptedExamItemOnClick,context as IAnalyticsCall)
        holder.examAttemptedItemBinding.executePendingBindings()
    }

    override fun getItemCount(): Int = dataList.size
    class BindingViewHolder(val examAttemptedItemBinding: ItemLayoutExamsAttemptedBinding) :
        RecyclerView.ViewHolder(examAttemptedItemBinding.root)

}