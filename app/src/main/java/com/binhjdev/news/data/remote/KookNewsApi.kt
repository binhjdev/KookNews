package com.binhjdev.news.data.remote

import com.binhjdev.news.data.remote.dto.KookNewsResponse
import com.binhjdev.news.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface KookNewsApi {
    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("source") sources: String,
        @Query("apiKey") apiKey: String = Constants.NEWS_API_KEYS
    ): KookNewsResponse
}