package com.ncidious.ncidious.ui.flashcards

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ncidious.ncidious.R
import com.ncidious.ncidious.data.network.responses.FlashCardTopicListResponse
import com.ncidious.ncidious.databinding.FragmentFlashCardDetailsBinding
import com.ncidious.ncidious.databinding.FragmentFlashCardDetailsBindingImpl


class FlashCardDetailsFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding:FragmentFlashCardDetailsBinding=FragmentFlashCardDetailsBinding.inflate(inflater, container, false)

        val flashCardSelected: FlashCardTopicListResponse? =arguments?.getParcelable<FlashCardTopicListResponse>("flashCard_key")

        binding.topicDetail=flashCardSelected

        return binding.root
    }

}