package com.almulygil.technicalexamtmdb.home.popular.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.almulygil.technicalexamtmdb.common.data.entity.IMovieType

@Entity(tableName = "tbl_movie_data_popular")
data class PopularMovie(
    val movieId: Long,
    val poster: String,
    @PrimaryKey
    val title: String,
    val description: String,
) : IMovieType