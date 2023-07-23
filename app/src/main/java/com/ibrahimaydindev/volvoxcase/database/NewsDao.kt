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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(article: News)

    @Delete
    suspend fun deleteArticle(article: News)
    @Query("SELECT * FROM news WHERE id = :articleId")
    suspend fun getArticle(articleId: Int): News


}