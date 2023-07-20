package com.ibrahimaydindev.volvoxcase.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ibrahimaydindev.volvoxcase.model.News

@Dao
interface NewsDao {
    @Query("SELECT * FROM news")
    fun getAllArticles(): LiveData<List<News>>
}