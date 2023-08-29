package com.almulygil.technicalexamtmdb.common.di

import com.almulygil.technicalexamtmdb.home.popular.data.apihelper.PopularMovieService

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun providePopularMoviesService(retrofit: Retrofit): PopularMovieService =
        retrofit.create(PopularMovieService::class.java)


}