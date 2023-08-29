package com.almulygil.technicalexamtmdb

import android.app.Application
import com.almulygil.technicalexamtmdb.base.local.DataStoreProvider
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DataStoreProvider.init(this)
    }
}