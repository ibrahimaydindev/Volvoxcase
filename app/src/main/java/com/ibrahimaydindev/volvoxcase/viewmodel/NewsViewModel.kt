package com.ibrahimaydindev.volvoxcase.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahimaydindev.volvoxcase.model.News
import com.ibrahimaydindev.volvoxcase.model.NewsResponse
import com.ibrahimaydindev.volvoxcase.repository.NewsRepository
import com.ibrahimaydindev.volvoxcase.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(
    val newsRepository: NewsRepository
) : ViewModel() {
    val getNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var getNewsPage = 1
    var getNewsResponse: NewsResponse? = null

    init {
        getNews("tr")
    }

    fun getNews(countryCode: String) = viewModelScope.launch {
        getNews.postValue(Resource.Loading())
        val response = newsRepository.getRealNews(countryCode,getNewsPage)
        getNews.postValue(handleNewsResponse(response))
    }

    private fun handleNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                getNewsPage++
                if (getNewsResponse == null) {
                    getNewsResponse = resultResponse
                } else {
                    val olArticles = getNewsResponse?.articles
                    val newArticles = resultResponse.articles
                    olArticles?.addAll(newArticles)
                }
                return Resource.Success(getNewsResponse ?: resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    fun saveArticle(article: News) = viewModelScope.launch {
        newsRepository.insertArticle(article)
    }

    fun deleteArticle(article: News) = viewModelScope.launch {
        newsRepository.deleteArticle(article)
    }
    fun getsavedNews() = newsRepository.getAllArticles()
}