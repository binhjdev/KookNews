package com.binhjdev.news.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.binhjdev.news.data.remote.KookNewsApi
import com.binhjdev.news.data.remote.KookNewsPagingSource
import com.binhjdev.news.domain.model.Article
import com.binhjdev.news.domain.repository.KookNewsRepository
import kotlinx.coroutines.flow.Flow

class KookNewsRepositoryImpl(
    private val kookNewsApi: KookNewsApi
) : KookNewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                KookNewsPagingSource(
                    kookNewsApi = kookNewsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }
}