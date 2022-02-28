package com.ncidious.ncidious.data.network

import com.ncidious.ncidious.data.network.responses.LoginResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LogInApi {
    @FormUrlEncoded
    @POST("login")
    suspend fun userLogin(
        @Field("phoneno") mobileNumber:String,
        @Field("passwozd") password:String
    ): Response<LoginResponse>


    companion object{
        operator fun invoke():LogInApi{
            return Retrofit.Builder().baseUrl("").
                    addConverterFactory(GsonConverterFactory.create()).
                    build().create(LogInApi::class.java)
        }
    }
}