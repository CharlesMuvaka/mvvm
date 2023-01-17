package com.example.news.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.news.R
import com.example.news.models.ArticleX
import kotlinx.android.synthetic.main.news_article.view.*

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

    var listDiffer = AsyncListDiffer(this, diffUtil)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.news_article,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val newsArticle = listDiffer.currentList[position]
        holder.itemView.apply {
            tvSource.text = newsArticle.source.name
            tvTitle.text = newsArticle.title
            tvDescription.text = newsArticle.description
            tvPublishedAt.text = newsArticle.publishedAt
            Glide.with(this).load(newsArticle.urlToImage).into(ivArticleImage)
        }
    }

    override fun getItemCount() = listDiffer.currentList.size
}