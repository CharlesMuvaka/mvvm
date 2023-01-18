package com.example.news.repository

import com.example.news.api.RetrofitInstance
import com.example.news.database.NewsDatabase
import com.example.news.models.Article
import retrofit2.Response

class NewsRepository(val db: NewsDatabase) {

    suspend fun getBreakingNews(countryCode: String, pageNumber:Int): Response<Article>{
        return RetrofitInstance.apiInstance.getBreakingNews(countryCode, pageNumber)
    }
}