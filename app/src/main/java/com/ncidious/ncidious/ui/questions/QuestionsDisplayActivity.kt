package com.ncidious.ncidious.ui.questions

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ScrollView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.ncidious.ncidious.R
import com.ncidious.ncidious.databinding.ActivityQuestionsBinding

class QuestionsDisplayActivity : AppCompatActivity() {
    lateinit var questionsViewModel: QuestionsViewModel
    lateinit var binding: ActivityQuestionsBinding
    var choosedOptions = ArrayList<Int>()
    var optionA_Clicked = false
    var optionB_Clicked = false
    var optionC_Clicked = false
    var optionD_Clicked = false

    lateinit var bottomSheetDialog: BottomSheetDialog
    lateinit var reviewQuestionModelList:ArrayList<ReviewQuestionModel>
    lateinit var reviewQuestion_rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_questions)
        questionsViewModel = ViewModelProvider(this).get(QuestionsViewModel::class.java)
        lifecycle.addObserver(QuestionsViewModel())
        questionsViewModel.getCurrentQuestionData().observe(this, Observer {
            binding.question = it

        })
        for (j in 0..3) {
            choosedOptions.add(0)
        }
        questionsViewModel.choosedOptions.addAll(choosedOptions)


    }

    fun onPreviousBtnClicked(view: View) {
        questionsViewModel.onPreviousBtnClick()
        binding.questionsScrollView.fullScroll(ScrollView.FOCUS_UP)
       questionsViewModel.setSelectedOptions(
            questionsViewModel.currentQuestionIndex,
            binding.optionALayout,
            binding.optionBLayout,
            binding.optionCLayout,
            binding.optionDLayout
        )

    }

    fun onNextBtnClicked(view: View) {
        questionsViewModel.onNextButtonClick()
        binding.questionsScrollView.fullScroll(ScrollView.FOCUS_UP)
       questionsViewModel.setSelectedOptions(
            questionsViewModel.currentQuestionIndex,
            binding.optionALayout,
            binding.optionBLayout,
            binding.optionCLayout,
            binding.optionDLayout
        )

    }

    fun onBookMarkQuestionClick(view: View) = questionsViewModel.onBookMarkQuestion()
    fun onShowTestStatusClick(view: View) = questionsViewModel.onShowTestStatusInfo()
    fun onShowQuestionsInfoClick(view: View) {
        reviewQuestionModelList = java.util.ArrayList<ReviewQuestionModel>()
        reviewQuestionModelList.add(ReviewQuestionModel(1))
        reviewQuestionModelList.add(ReviewQuestionModel(1))
        reviewQuestionModelList.add(ReviewQuestionModel(0))
        reviewQuestionModelList.add(ReviewQuestionModel(1))
        reviewQuestionModelList.add(ReviewQuestionModel(2))
        reviewQuestionModelList.add(ReviewQuestionModel(1))
        reviewQuestionModelList.add(ReviewQuestionModel(3))
        reviewQuestionModelList.add(ReviewQuestionModel(1))
        bottomSheetDialog =
            BottomSheetDialog(this@QuestionsDisplayActivity,R.style.BottomSheetTheme)
        val view: View = LayoutInflater.from(getApplicationContext()).inflate(
            R.layout.bottom_sheet_questiondisplay,
            findViewById(R.id.bottom_sheet_root)
        )
        reviewQuestion_rv = view.findViewById(R.id.review_question_rv)
        val layoutManager = GridLayoutManager(this@QuestionsDisplayActivity, 5)
        reviewQuestion_rv.layoutManager = layoutManager

        val adapter = ReviewQuestionAdapter(reviewQuestionModelList)
        reviewQuestion_rv.adapter = adapter
        adapter.notifyDataSetChanged()
        bottomSheetDialog.setContentView(view)
        bottomSheetDialog.show()
    }

    fun onOptionAClicked(view: View) {
        if (!questionsViewModel.optionA_Clicked) {
            questionsViewModel.choosedOptions[0] = 1
            questionsViewModel.optionA_Clicked = true
            view.setBackgroundColor(Color.parseColor("#DCDCDC"))
        } else {

            view.setBackgroundColor(Color.parseColor("#FFFFFF"))
            questionsViewModel.optionA_Clicked = false
            questionsViewModel.choosedOptions[0] = 0

        }

    }

    fun onOptionBClicked(view: View) {
        if (!questionsViewModel.optionB_Clicked) {
            questionsViewModel.choosedOptions[1] = 1
            questionsViewModel.optionB_Clicked = true
            view.setBackgroundColor(Color.parseColor("#DCDCDC"))
        } else {
            view.setBackgroundColor(Color.parseColor("#FFFFFF"))
            questionsViewModel.optionB_Clicked = false
            questionsViewModel.choosedOptions[1] = 0

        }
    }

    fun onOptionCClicked(view: View) {
        if (!questionsViewModel.optionC_Clicked) {
            questionsViewModel.optionC_Clicked = true
            questionsViewModel.choosedOptions[2] = 1
            view.setBackgroundColor(Color.parseColor("#DCDCDC"))
        } else {
            view.setBackgroundColor(Color.parseColor("#FFFFFF"))
            questionsViewModel.optionC_Clicked = false
            questionsViewModel.choosedOptions[2] = 0
        }
    }

    fun onOptionDClicked(view: View) {
        if (!questionsViewModel.optionD_Clicked) {
            questionsViewModel.optionD_Clicked = true
            questionsViewModel.choosedOptions[3] = 1
            view.setBackgroundColor(Color.parseColor("#DCDCDC"))
        } else {
            view.setBackgroundColor(Color.parseColor("#FFFFFF"))
            questionsViewModel.optionD_Clicked = false
            questionsViewModel.choosedOptions[3] = 0
        }
    }

    fun onShowMarksDistributionClick(view: View) {}

}