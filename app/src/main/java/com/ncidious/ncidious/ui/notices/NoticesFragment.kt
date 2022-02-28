package com.ncidious.ncidious.ui.notices

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ncidious.ncidious.R
import com.ncidious.ncidious.data.network.responses.NoticeResponse
import com.ncidious.ncidious.databinding.FragmentNoticesBindingImpl
import java.util.ArrayList


class NoticesFragment : Fragment() {
    private lateinit var list: List<NoticeResponse>
    lateinit var noticesViewModel: NoticesViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        list = ArrayList<NoticeResponse>()
        (list as ArrayList<NoticeResponse>).add(
            NoticeResponse(
                "https://www.motachashma.com/images/nta-logo-neet-min.jpg",
                "12/04/2021",
                "Toomorow is your JEE MAINS TEST",
            )
        )
        (list as ArrayList<NoticeResponse>).add(
            NoticeResponse(
                "https://www.motachashma.com/images/nta-logo-neet-min.jpg",
                "12/04/2021",
                "Toomorow is your JEE MAINS TEST",
            )
        )
        (list as ArrayList<NoticeResponse>).add(
            NoticeResponse(
                "https://www.motachashma.com/images/nta-logo-neet-min.jpg",
                "12/04/2021",
                "Toomorow is your JEE MAINS TEST",
            )
        )
        var binding: FragmentNoticesBindingImpl =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_notices, container, false)
        noticesViewModel = ViewModelProvider(this).get(NoticesViewModel::class.java)
        binding.noticeList = list

        return binding.root
    }


}