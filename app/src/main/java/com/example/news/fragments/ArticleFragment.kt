package com.example.news.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.news.MainActivity
import com.example.news.R

class ArticleFragment: Fragment(R.layout.fragment_article) {
    lateinit var newsViewModel:ViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsViewModel = (activity as MainActivity).viewModel
    }
}