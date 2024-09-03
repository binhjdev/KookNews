package com.binhjdev.news.domain.usecases.news

import androidx.paging.PagingData
import com.binhjdev.news.domain.model.Article
import com.binhjdev.news.domain.repository.KookNewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val kookNewsRepository: KookNewsRepository
) {

    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return kookNewsRepository.getNews(sources = sources)
    }
}