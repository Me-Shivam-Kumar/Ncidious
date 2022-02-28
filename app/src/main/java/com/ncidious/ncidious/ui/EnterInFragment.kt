package com.ncidious.ncidious.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.ncidious.ncidious.R
import com.ncidious.ncidious.ui.home.MainActivity
import com.ncidious.ncidious.ui.signup.SignUpFragment

class EnterInFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        lateinit var goToLogIn: TextView
        lateinit var goToSignUp: TextView

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_enter_in, container, false)
        goToLogIn=view.findViewById(R.id.go_to_login_Btn)
        goToSignUp=view.findViewById(R.id.go_to_signup_Btn)

        goToLogIn.setOnClickListener(View.OnClickListener {
            val intent:Intent= Intent(it.context, MainActivity::class.java)
            startActivity(intent)
        })
        goToSignUp.setOnClickListener(View.OnClickListener {
            val signUpFragment: Fragment = SignUpFragment()
            val transaction: FragmentTransaction = parentFragmentManager!!.beginTransaction().replace(
                R.id.register_or_auth_frameLayout,
                signUpFragment
            )
            transaction.commit()
        })
        return view
    }


}
