package com.example.myexample2.ui.main.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {
        private const val BaseUrl = "https://reqres.in"

        private val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        fun getService(): UserAPICall {
            return retrofit.create(UserAPICall::class.java)
        }


}
