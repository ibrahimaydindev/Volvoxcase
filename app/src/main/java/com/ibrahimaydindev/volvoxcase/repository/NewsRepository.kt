package com.ibrahimaydindev.volvoxcase.repository

import com.ibrahimaydindev.volvoxcase.api.RetrofitInstance
import com.ibrahimaydindev.volvoxcase.database.NewsDatabase
import com.ibrahimaydindev.volvoxcase.model.News

class NewsRepository(val db: NewsDatabase) {
    suspend fun getRealNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getNews(countryCode, pageNumber)
    suspend fun insertArticle (article: News) = db.getArticleDao().insertArticle(article)
    suspend fun deleteArticle (article: News) = db.getArticleDao().deleteArticle(article)
    fun getAllArticles() = db.getArticleDao().getAllArticles()

    fun getSavedNews() = db.getArticleDao().getAllArticles()
}