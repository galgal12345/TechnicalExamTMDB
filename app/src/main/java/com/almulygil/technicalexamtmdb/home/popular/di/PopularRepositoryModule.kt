package com.almulygil.technicalexamtmdb.home.popular.di

import com.almulygil.technicalexamtmdb.home.popular.data.apihelper.IPopularMoviesRepository
import com.almulygil.technicalexamtmdb.home.popular.data.apihelper.PopularMoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PopularRepositoryModule {

    @Provides
    @Singleton
    fun providePopularMoviesRepository(iPopularMoviesRepository: IPopularMoviesRepository): PopularMoviesRepository {
        return iPopularMoviesRepository
    }
}