package com.almulygil.technicalexamtmdb.common.di

import com.almulygil.technicalexamtmdb.common.data.local.store.IUserPreferenceManager
import com.almulygil.technicalexamtmdb.common.data.local.store.UserPreferenceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UserPreferencesModule {

    @Provides
    @Singleton
     fun provideUserPreferenceManager(): UserPreferenceManager{
         return IUserPreferenceManager()
     }
}