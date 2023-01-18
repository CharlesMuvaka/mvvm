package com.example.news.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news.MainActivity
import com.example.news.R
import com.example.news.adapters.NewsAdapter
import kotlinx.android.synthetic.main.fragment_breaking_news.*

class BreakingNewsFragment: Fragment(R.layout.fragment_breaking_news) {
    lateinit var newsViewModel: ViewModel
    lateinit var newsAdapter: NewsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsViewModel = (activity as MainActivity).viewModel
    }

    private fun setupRecyclerView(){
        newsAdapter = NewsAdapter()
        rvRecView.apply {
            this.adapter = newsAdapter
            this.layoutManager = LinearLayoutManager(context)
        }

    }
}