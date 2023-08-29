package com.almulygil.technicalexamtmdb.common.data.local.store

import androidx.datastore.preferences.preferencesKey
import com.almulygil.technicalexamtmdb.common.data.local.store.IUserPreferenceManager.Keys.USER_NAME
import com.almulygil.technicalexamtmdb.base.local.DataStoreProvider.getValue
import com.almulygil.technicalexamtmdb.base.local.DataStoreProvider.setValue
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class IUserPreferenceManager @Inject constructor() : UserPreferenceManager {

    override suspend fun setUserName(name: String) {
        setValue(USER_NAME, name)
    }

    override suspend fun getUserUserName(): Flow<String?> {
        return getValue(USER_NAME).map { it }
    }

    object Keys {
        val USER_NAME = preferencesKey<String>("user_name")
    }
}