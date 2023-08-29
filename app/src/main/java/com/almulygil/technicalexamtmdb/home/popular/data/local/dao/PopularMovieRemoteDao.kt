package com.almulygil.technicalexamtmdb.home.popular.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.almulygil.technicalexamtmdb.home.popular.data.local.entity.PopularMoviesRemoteKeys

@Dao
interface PopularMovieRemoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<PopularMoviesRemoteKeys>)

    @Query("SELECT * FROM popular_movie_remote_keys WHERE movieId = :movieId")
    suspend fun remoteKeysByMovieId(movieId: Long): PopularMoviesRemoteKeys?

    @Query("DELETE FROM popular_movie_remote_keys")
    suspend fun clearRemoteKeys()
}