package com.ncidious.ncidious.ui.questions

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.lifecycle.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.ncidious.ncidious.data.network.responses.QuestionResponse
import com.ncidious.ncidious.data.repositories.QuestionsRepository

class QuestionsViewModel : ViewModel(), LifecycleObserver {
    private lateinit var questionList: List<QuestionResponse>
    private var question: MutableLiveData<QuestionResponse> = MutableLiveData<QuestionResponse>()
    var currentQuestionIndex: Int = 0
    var optionA_Clicked = false
    var optionB_Clicked = false
    var optionC_Clicked = false
    var optionD_Clicked = false
    var choosedOptions = ArrayList<Int>()
    var intList: List<Int> = listOf<Int>(0, 0, 0, 0)
    var allQuestionsChoosedOptions =
        Array<List<Int>>(QuestionsRepository().getQuestionsList().size) { intList }




    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        for (x in allQuestionsChoosedOptions) {
            for (i in x) {
                System.out.print(i)
            }
        }

        System.out.println(choosedOptions)
    }


    fun getCurrentQuestionData(): LiveData<QuestionResponse> {
        questionList = ArrayList()
        questionList = QuestionsRepository().getQuestionsList()
        question.value = questionList[currentQuestionIndex]
        return question
    }

    fun onNextButtonClick() {
        val options = ArrayList<Int>()
        options.addAll(choosedOptions)
        allQuestionsChoosedOptions.set(currentQuestionIndex, options)
        for (v in allQuestionsChoosedOptions) {
            System.out.println(v)
        }
        choosedOptions.clear()
        for (j in 0..3) {
            choosedOptions.add(0)
        }
        currentQuestionIndex++
        if (currentQuestionIndex > questionList.size - 1) {

        } else {
            question.value = questionList[currentQuestionIndex]
        }

    }

    fun onPreviousBtnClick() {
        currentQuestionIndex--
        if (currentQuestionIndex >= 0) {
            question.value = questionList[currentQuestionIndex]
        }
    }

    fun setSelectedOptions(
        questionIndex: Int,
        optionA_LinearLayout: LinearLayout,
        optionB_LinearLayout: LinearLayout,
        optionC_LinearLayout: LinearLayout,
        optionD_LinearLayout: LinearLayout
    ) {
        val selectedOptions = allQuestionsChoosedOptions[questionIndex]
        optionA_Clicked = if (selectedOptions.get(0) == 0) {
            optionA_LinearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"))
            choosedOptions[0] = 0
            false
        } else {
            choosedOptions[0] = 1
            optionA_LinearLayout.setBackgroundColor(Color.parseColor("#DCDCDC"))
            true
        }
        optionB_Clicked = if (selectedOptions.get(1) == 0) {
            choosedOptions[1] = 0
            optionB_LinearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"))
            false
        } else {
            choosedOptions[1] = 1
            optionB_LinearLayout.setBackgroundColor(Color.parseColor("#DCDCDC"))
            true
        }
        optionC_Clicked = if (selectedOptions.get(2) == 0) {
            choosedOptions[2] = 0
            optionC_LinearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"))
            false
        } else {
            choosedOptions[2] = 1
            optionC_LinearLayout.setBackgroundColor(Color.parseColor("#DCDCDC"))
            true
        }
        optionD_Clicked = if (selectedOptions.get(3) == 0) {
            choosedOptions[3] = 0
            optionD_LinearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"))
            false
        } else {
            choosedOptions[3] = 1
            optionD_LinearLayout.setBackgroundColor(Color.parseColor("#DCDCDC"))
            true
        }
    }



    fun onShowTestStatusInfo() {
    }

    fun onBookMarkQuestion() {

    }
}