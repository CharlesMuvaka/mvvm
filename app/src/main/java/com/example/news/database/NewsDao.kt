package com.example.news.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.news.models.ArticleX

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article:ArticleX):Long //inserts or updates an entity in the db

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<ArticleX>> //live data updates all its observes in case of any data change

    @Delete
    suspend fun deleteArticle(article:ArticleX)
}