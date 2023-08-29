package com.almulygil.technicalexamtmdb.home.popular.data.apihelper

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.almulygil.technicalexamtmdb.common.data.local.db.MovieDatabase
import com.almulygil.technicalexamtmdb.home.popular.data.local.entity.PopularMovie
import com.almulygil.technicalexamtmdb.home.popular.data.remote.PopularMoviesRemoteMediator
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IPopularMoviesRepository @Inject constructor(
    private val database: MovieDatabase,
    private val popularMoviesRemoteMediator: PopularMoviesRemoteMediator
) : PopularMoviesRepository {

    @OptIn(ExperimentalPagingApi::class)
    override suspend fun getPopularMovies(): Flow<PagingData<PopularMovie>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = true,
                prefetchDistance = 5,
                initialLoadSize = 40
            ),
            remoteMediator = popularMoviesRemoteMediator,
            pagingSourceFactory = { database.popularMovieDao().getMovies() }
        ).flow
    }
}