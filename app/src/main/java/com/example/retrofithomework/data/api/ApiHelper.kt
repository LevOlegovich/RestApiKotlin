package com.example.retrofithomework.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiHelper {


    companion object {
        fun getBookApi(): BookApi {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://spring-boot-mysql-server-part0.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(BookApi::class.java)
        }

    }

}