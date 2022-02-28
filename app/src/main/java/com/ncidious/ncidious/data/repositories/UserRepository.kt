package com.ncidious.ncidious.data.repositories

import com.ncidious.ncidious.data.network.LogInApi
import com.ncidious.ncidious.data.network.responses.LoginResponse
import com.ncidious.ncidious.data.network.SafeApiRequest

class UserRepository: SafeApiRequest() {
    suspend fun userLogin(mobileNumber:String,password:String): LoginResponse{
        return apiRequest{LogInApi.invoke().userLogin(mobileNumber,password)}
    }
}