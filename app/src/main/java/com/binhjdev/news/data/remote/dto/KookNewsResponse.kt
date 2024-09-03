package com.binhjdev.news.data.remote.dto

import com.binhjdev.news.domain.model.Article

data class KookNewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)