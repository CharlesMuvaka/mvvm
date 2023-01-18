package com.example.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.news.database.NewsDatabase
import com.example.news.repository.NewsRepository
import com.example.news.viewmodels.NewsViewModel
import com.example.news.viewmodels.NewsViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: NewsViewModel //initialising a view model instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = NewsRepository(NewsDatabase(this)) //initialising a repository instance
        val provider = NewsViewModelProvider(repository) //initialising a view model provider instance
        viewModel = ViewModelProvider(this, provider)[NewsViewModel::class.java] //creating the view model instance

        val navHostFragment = supportFragmentManager.findFragmentById(fragmentContainerView.id) as NavHostFragment
        bottom.setupWithNavController(navHostFragment.navController)

    }
}