package com.example.news.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.news.models.ArticleX

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article:ArticleX):Long //inserts or updates an entity in the db

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<ArticleX>>
}