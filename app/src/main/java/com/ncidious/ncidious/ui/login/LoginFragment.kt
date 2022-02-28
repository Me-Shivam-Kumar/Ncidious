package com.ncidious.ncidious.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.ncidious.ncidious.R
import com.ncidious.ncidious.databinding.FragmentLoginBinding
import com.ncidious.ncidious.ui.signup.SignUpFragment

class LoginFragment : Fragment(R.layout.fragment_login) {
    // TODO: Rename and change types of parameters
    lateinit var loginViewModel: LoginViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var binding :FragmentLoginBinding= DataBindingUtil.inflate(layoutInflater,R.layout.fragment_login,container,false)
        loginViewModel= ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.loginViewModel=loginViewModel

        binding.doNotHaveAnAccount.setOnClickListener(View.OnClickListener{
            val signUpFragment: Fragment = SignUpFragment()
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction().replace(R.id.register_or_auth_frameLayout,signUpFragment)
            transaction.commit()
        })

        return binding.root;

    }


}