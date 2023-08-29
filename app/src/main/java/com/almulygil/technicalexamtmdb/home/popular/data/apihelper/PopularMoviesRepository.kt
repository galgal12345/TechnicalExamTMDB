package com.almulygil.technicalexamtmdb.home.popular.data.apihelper

import androidx.paging.PagingData
import com.almulygil.technicalexamtmdb.home.popular.data.local.entity.PopularMovie
import kotlinx.coroutines.flow.Flow

interface PopularMoviesRepository {

    suspend fun getPopularMovies(): Flow<PagingData<PopularMovie>>

}