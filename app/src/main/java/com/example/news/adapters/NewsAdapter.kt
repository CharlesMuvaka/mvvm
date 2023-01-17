package com.example.news.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.news.models.ArticleX

class NewsAdapter:RecyclerView.Adapter<NewsAdapter.MyHolder>() {
    inner class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private val diffUtil = object : DiffUtil.ItemCallback<ArticleX>() {
        override fun areItemsTheSame(oldItem: ArticleX, newItem: ArticleX): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: ArticleX, newItem: ArticleX): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}