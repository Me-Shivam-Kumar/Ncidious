package com.ncidious.ncidious.ui.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import com.ncidious.ncidious.R
import com.ncidious.ncidious.ui.login.LoginFragment


class SignUpFragment : Fragment() {
    lateinit var alreadyHaveAccountBtn: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_sign_up, container, false)
        alreadyHaveAccountBtn=view.findViewById(R.id.already_have_an_account)
        alreadyHaveAccountBtn.setOnClickListener(View.OnClickListener{
            val logInFragment: Fragment = LoginFragment()
            val transaction: FragmentTransaction = parentFragmentManager!!.beginTransaction().replace(R.id.register_or_auth_frameLayout,logInFragment)
            transaction.commit()
        })
        return view
    }


}