package com.almulygil.technicalexamtmdb.home.popular.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.almulygil.technicalexamtmdb.home.popular.data.local.entity.PopularMovie

@Dao
interface PopularMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movieResponse: List<PopularMovie>)

    @Query("select * from tbl_movie_data_popular")
    fun getMovies(): PagingSource<Int, PopularMovie>

    @Query("DELETE FROM tbl_movie_data_popular")
    suspend fun clearMovies()
}