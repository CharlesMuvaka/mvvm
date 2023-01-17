package com.example.news.converters

import androidx.room.TypeConverter
import com.example.news.models.Source


class Converter {
    @TypeConverter()
     fun fromSource(source: Source): String{ //converts the source class to a string to be stored in the db
         return source.name
     }
    @TypeConverter
    fun toSource(name:String):Source{ //converts the string stored in the database as source back to its original source
        return Source(name, name)
    }


}