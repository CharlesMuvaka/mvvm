package com.example.news.repository

import com.example.news.api.RetrofitInstance
import com.example.news.database.NewsDatabase

class NewsRepository(val db: NewsDatabase) {

    suspend fun getBreakingNews(countryCode: String, pageNumber:Int){
        RetrofitInstance.apiInstance.getBreakingNews(countryCode, pageNumber)
    }
}