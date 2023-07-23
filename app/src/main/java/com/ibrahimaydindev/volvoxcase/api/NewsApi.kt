package com.ibrahimaydindev.volvoxcase.api

import com.ibrahimaydindev.volvoxcase.model.NewsResponse
import com.ibrahimaydindev.volvoxcase.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("v2/everything?q=teknoloji")
    suspend fun getNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>
}