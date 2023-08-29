package com.almulygil.technicalexamtmdb.common.data.local.db

import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.almulygil.technicalexamtmdb.base.utils.typeconverter.TypeConverter

import com.almulygil.technicalexamtmdb.home.popular.data.local.dao.PopularMovieDao
import com.almulygil.technicalexamtmdb.home.popular.data.local.dao.PopularMovieRemoteDao
import com.almulygil.technicalexamtmdb.home.popular.data.local.entity.PopularMovie
import com.almulygil.technicalexamtmdb.home.popular.data.local.entity.PopularMoviesRemoteKeys

@Database(
    entities = [PopularMovie::class, PopularMoviesRemoteKeys::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(TypeConverter::class)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun popularMovieDao(): PopularMovieDao
    abstract fun popularMovieRemoteDao(): PopularMovieRemoteDao


    companion object {
        @Volatile
        private var INSTANCE: MovieDatabase? = null

        fun getInstance(context: Context): MovieDatabase =
            INSTANCE ?: synchronized(this) { INSTANCE ?: buildDatabase(context).also { INSTANCE = it } }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, MovieDatabase::class.java, "MovieDatabase.db").build()
    }



}