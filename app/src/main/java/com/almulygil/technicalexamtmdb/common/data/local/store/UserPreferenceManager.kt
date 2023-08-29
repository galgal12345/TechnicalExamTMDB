package com.almulygil.technicalexamtmdb.common.data.local.store


import kotlinx.coroutines.flow.Flow



interface UserPreferenceManager {
    suspend fun setUserName(name: String)
    suspend fun getUserUserName(): Flow<String?>
}