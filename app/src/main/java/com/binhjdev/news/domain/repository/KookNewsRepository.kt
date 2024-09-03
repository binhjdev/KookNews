package com.binhjdev.news.domain.repository

import androidx.paging.PagingData
import com.binhjdev.news.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface KookNewsRepository {
    fun getNews(sources: List<String>): Flow<PagingData<Article>>
}