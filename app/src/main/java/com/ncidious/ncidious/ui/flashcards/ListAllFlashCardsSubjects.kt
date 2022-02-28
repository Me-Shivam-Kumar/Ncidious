package com.ncidious.ncidious.ui.flashcards

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ncidious.ncidious.R
import com.ncidious.ncidious.databinding.FragmentListAllFlashCardsSubjectsBinding


class ListAllFlashCardsSubjects : Fragment() {
    lateinit var flashCardTopicListViewModel:FlashCardTopicListViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding:FragmentListAllFlashCardsSubjectsBinding= DataBindingUtil.inflate(layoutInflater,
        R.layout.fragment_list_all_flash_cards_subjects,container,false)
        flashCardTopicListViewModel= ViewModelProvider(this).get(FlashCardTopicListViewModel::class.java)

        flashCardTopicListViewModel.getFlashCardTopicListData().observe(viewLifecycleOwner,
            Observer{
                binding.flashCardTopicList=it
            }
        )
        return binding.root
    }


}