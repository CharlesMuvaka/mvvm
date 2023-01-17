package com.example.news.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.news.models.ArticleX

@Database(
    entities = [ArticleX::class],
    version = 1
)
abstract class NewsDatabase: RoomDatabase() {
    abstract fun getNewsDao(): NewsDao

    companion object{
        @Volatile // changes to the instance are made visible to other threads
        private var instance:NewsDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK){ //ensures only one instance is created
            instance?:  createDatabaseInstance(context).also{ instance = it}
        }

        private fun createDatabaseInstance(context: Context): NewsDatabase{ //creating the database instance
            return Room.databaseBuilder(context.applicationContext, NewsDatabase::class.java, "newsDb.db").build()
        }


    }
}