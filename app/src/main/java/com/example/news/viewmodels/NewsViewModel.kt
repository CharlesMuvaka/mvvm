package com.example.news.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.models.Article
import com.example.news.models.Resource
import com.example.news.repository.NewsRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(private val repository: NewsRepository): ViewModel() {
    private val breakingNews: MutableLiveData<Resource<Article>> = MutableLiveData()
    var pageNumber: Int = 1

    fun getBreakingNews(countryCode:String) = viewModelScope.launch {
        breakingNews.postValue(Resource.Loading())
        val response: Response<Article> = repository.getBreakingNews(countryCode, pageNumber)
        breakingNews.postValue(getBreakingNewsState(response))
    }

    private fun getBreakingNewsState(response: Response<Article>): Resource<Article>{
        if (response.isSuccessful){
            response.body()?.let { newsArticles ->
                return Resource.Success(newsArticles)
            }
        }
        return Resource.Failure(response.message())
    }
}