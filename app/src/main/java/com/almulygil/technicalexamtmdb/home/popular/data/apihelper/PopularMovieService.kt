package com.almulygil.technicalexamtmdb.home.popular.data.apihelper

import com.almulygil.technicalexamtmdb.common.data.entity.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularMovieService {

    @GET("popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String, @Query("page") page: Int
    ): MoviesResponse
}