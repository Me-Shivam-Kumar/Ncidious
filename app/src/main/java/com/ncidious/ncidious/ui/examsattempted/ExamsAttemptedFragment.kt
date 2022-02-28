package com.ncidious.ncidious.ui.examsattempted

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ncidious.ncidious.R
import com.ncidious.ncidious.databinding.FragmentExamsAttemptedBinding

class ExamsAttemptedFragment : Fragment() {
    lateinit var examsAttemptedViewModel: ExamsAttemptedViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var binding: FragmentExamsAttemptedBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_exams_attempted,
            container,
            false
        )
        examsAttemptedViewModel= ViewModelProvider(this).get(ExamsAttemptedViewModel::class.java)

        examsAttemptedViewModel.getExamsAttemptedListData().observe(viewLifecycleOwner, Observer{
            binding.examAttemptedList=it
        })

        return binding.root
    }


}