package com.almulygil.technicalexamtmdb.common.extension

import com.almulygil.technicalexamtmdb.common.data.entity.Movies
import com.almulygil.technicalexamtmdb.common.data.entity.MoviesResponse
import com.almulygil.technicalexamtmdb.home.popular.data.local.entity.PopularMovie

fun MoviesResponse.mapDataToPopularMovies(): Movies =
    with(this) {
        Movies(
            total = total,
            page = page,
            movies = results.map {
                PopularMovie(
                    it.id,
                    it.posterPath,
                    it.title,
                    it.overview
                )
            }
        )
    }


