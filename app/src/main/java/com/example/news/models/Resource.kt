package com.example.news.models

sealed class Resource<T> (val data: T? = null, val message: String? = null){
    class Success<T>(private val newsData:T): Resource<T>(newsData)
    class Failure<T>( private val errorMessage:String, private val newsData:T? = null,): Resource<T>(newsData,errorMessage )
    class Loading<T>: Resource<T>()
}