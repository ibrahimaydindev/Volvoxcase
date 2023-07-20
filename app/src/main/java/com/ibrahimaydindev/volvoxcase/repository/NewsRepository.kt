package com.ibrahimaydindev.volvoxcase.repository

import com.ibrahimaydindev.volvoxcase.api.RetrofitInstance
import com.ibrahimaydindev.volvoxcase.database.NewsDatabase

class NewsRepository(val db: NewsDatabase) {
    suspend fun getRealNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getNews(countryCode, pageNumber)
}