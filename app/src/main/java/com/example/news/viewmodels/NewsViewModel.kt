package com.example.news.viewmodels

import androidx.lifecycle.ViewModel
import com.example.news.repository.NewsRepository

class NewsViewModel(val repository: NewsRepository): ViewModel() {
}