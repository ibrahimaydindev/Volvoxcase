package com.ibrahimaydindev.volvoxcase.database

import androidx.room.TypeConverter
import com.ibrahimaydindev.volvoxcase.model.Source

class Converters {
    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }
    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}