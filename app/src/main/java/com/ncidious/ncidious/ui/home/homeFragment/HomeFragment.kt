package com.ncidious.ncidious.ui.home.homeFragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.ncidious.ncidious.R
import com.ncidious.ncidious.ui.flashcards.FlashCards
import com.ncidious.ncidious.ui.questions.QuestionsDisplayActivity

class HomeFragment : Fragment(), View.OnClickListener {
    lateinit var flashCardLl: LinearLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_home, container, false)
        var practiceLl=view.findViewById<LinearLayout>(R.id.practice_test_LL)
        flashCardLl=view.findViewById(R.id.flash_cards_LL)
        flashCardLl.setOnClickListener(this)
        practiceLl.setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        val id: Int = v!!.id
        when (id){
            R.id.flash_cards_LL->startActivity(Intent(v.context,FlashCards::class.java))
            R.id.practice_test_LL->startActivity(Intent(v.context,QuestionsDisplayActivity::class.java))
        }
    }

}