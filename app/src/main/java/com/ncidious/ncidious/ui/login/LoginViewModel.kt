package com.ncidious.ncidious.ui.login

import android.view.View
import androidx.lifecycle.ViewModel
import com.ncidious.ncidious.data.repositories.UserRepository
import com.ncidious.ncidious.util.ApiException
import com.ncidious.ncidious.util.Coroutines

class LoginViewModel : ViewModel() {
     var mobileNumber:String?=null;
     var password:String?=null

     fun onLoginButtonClicked(view:View) {
          if(mobileNumber.isNullOrEmpty()||password.isNullOrEmpty()){
               return
          }
          //success

          Coroutines.main {
               try{
                    val loginResponse=UserRepository().userLogin(mobileNumber!!, password!!)

               }catch(e: ApiException){

               }

          }

     }


}