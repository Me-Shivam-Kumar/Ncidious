package com.ncidious.ncidious.ui.questions

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ncidious.ncidious.R


class ReviewQuestionAdapter(var reviewQuestionModelList: List<ReviewQuestionModel>) :
    RecyclerView.Adapter<ReviewQuestionAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_review_question, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(reviewQuestionModelList[position].viewType)
    }

    override fun getItemCount(): Int {
        return reviewQuestionModelList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var rootViewReviewQuestion: LinearLayout
        var questionNo: TextView
        fun setData(type: Int) {
            questionNo.text = Integer.toString(adapterPosition + 1)
            if (type == 0) {
                rootViewReviewQuestion.setBackgroundColor(Color.parseColor("#FAFAFA"))
            }
            if (type == 1) {
                rootViewReviewQuestion.setBackgroundColor(Color.parseColor("#ff99cc00"))
            }
            if (type == 2) {
                rootViewReviewQuestion.setBackgroundColor(Color.parseColor("#ffaa66cc"))
            }
            if (type == 3) {
                rootViewReviewQuestion.setBackgroundColor(Color.parseColor("#ffffbb33"))
            }
        }

        init {
            rootViewReviewQuestion = itemView.findViewById(R.id.item_layout_review_question_root)
            questionNo = itemView.findViewById(R.id.item_layout_review_question_no)
        }
    }
}
