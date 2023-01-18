package com.example.news.models

sealed class Resource<T> (val data: T? = null, val message: String? = null){

}