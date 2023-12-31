package com.ibrahimaydindev.volvoxcase.model

data class NewsResponse(
    val articles: MutableList<News>,
    val status: String,
    val totalResults: Int
)
