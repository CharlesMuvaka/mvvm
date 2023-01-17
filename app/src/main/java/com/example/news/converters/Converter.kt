package com.example.news.converters

import androidx.room.TypeConverter
import com.example.news.models.Source


class Converter {
    @TypeConverter()
     fun fromSource(source: Source): String{ //converts the source class to a string to be stored in the db
         return source.name
     }


}