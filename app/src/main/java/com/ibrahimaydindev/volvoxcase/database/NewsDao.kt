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
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(article: News): Long

    @Query("SELECT * FROM news")
    fun getAllArticles(): LiveData<List<News>>

    @Delete
    fun deleteArticle(article: News)
}