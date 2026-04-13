package com.it.shka.core

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlin.text.orEmpty

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("user_token")

class UserTokenStorage(context: Context) {
    private val dataStore = context.dataStore
    private val tokenKey = stringPreferencesKey("user_key")

    val token: Flow<String> = dataStore.data.map { it[tokenKey].orEmpty() }

    suspend fun saveUserToken(value: String): Result<Unit> = runCatching {
        dataStore.edit { it[tokenKey] = value }
    }

}