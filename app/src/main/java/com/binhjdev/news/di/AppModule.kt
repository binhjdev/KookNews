package com.binhjdev.news.di

import android.app.Application
import com.binhjdev.news.data.manager.LocalUserManagerImpl
import com.binhjdev.news.data.remote.KookNewsApi
import com.binhjdev.news.data.repository.KookNewsRepositoryImpl
import com.binhjdev.news.domain.manager.LocalUserManager
import com.binhjdev.news.domain.repository.KookNewsRepository
import com.binhjdev.news.domain.usecases.app_entry.AppEntryUseCases
import com.binhjdev.news.domain.usecases.app_entry.ReadAppEntry
import com.binhjdev.news.domain.usecases.app_entry.SaveAppEntry
import com.binhjdev.news.domain.usecases.news.GetNews
import com.binhjdev.news.domain.usecases.news.NewsUseCases
import com.binhjdev.news.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application): LocalUserManager =
        LocalUserManagerImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(localUserManager: LocalUserManager): AppEntryUseCases =
        AppEntryUseCases(
            readAppEntry = ReadAppEntry(localUserManager),
            saveAppEntry = SaveAppEntry(localUserManager)
        )

    @Provides
    @Singleton
    fun provideNewsApi(): KookNewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(KookNewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideKookNewsRepository(
        newsApi: KookNewsApi
    ): KookNewsRepository = KookNewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: KookNewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository)
        )
    }
}