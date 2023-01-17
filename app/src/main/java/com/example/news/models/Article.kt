package com.example.news.models

data class Article(
    val articles: List<ArticleX>,
    val status: String,
    val totalResults: Int
)