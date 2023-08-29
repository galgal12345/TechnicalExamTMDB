package com.almulygil.technicalexamtmdb.home.popular.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.almulygil.technicalexamtmdb.home.popular.data.apihelper.PopularMoviesRepository
import com.almulygil.technicalexamtmdb.home.popular.data.local.entity.PopularMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class PopularMovieViewModel @Inject constructor(
    private val repository: PopularMoviesRepository
) : ViewModel() {

    suspend fun getPopularMovies(): Flow<PagingData<PopularMovie>> {
        return repository
            .getPopularMovies()
            .cachedIn(viewModelScope)
            .flowOn(Dispatchers.IO)
    }
}