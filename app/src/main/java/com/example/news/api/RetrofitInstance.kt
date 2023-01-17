package com.example.news.api

import okhttp3.logging.HttpLoggingInterceptor

class RetrofitInstance {
    companion object{
        private val retrofit by lazy{
            val logging = HttpLoggingInterceptor() // for logging the api response to the console
            logging.level = HttpLoggingInterceptor.Level.BODY
        }
    }
}