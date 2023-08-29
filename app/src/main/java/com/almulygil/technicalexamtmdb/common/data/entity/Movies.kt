package com.almulygil.technicalexamtmdb.common.data.entity

data class Movies(
    val total: Int = 0,
    val page: Int = 0,
    val movies: List<IMovieType>
) {

    val isEndOfListReached = total == page
}
