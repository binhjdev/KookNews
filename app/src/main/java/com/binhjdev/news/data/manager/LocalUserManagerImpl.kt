package com.binhjdev.news.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.binhjdev.news.domain.manager.LocalUserManager
import com.binhjdev.news.util.Constants
import com.binhjdev.news.util.Constants.USER_SETTING
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserManagerImpl(
    private val context: Context
) : LocalUserManager {
    override suspend fun saveAppEntry() {
        context.dataStore.edit { settings ->
            settings[PreferencesKKeys.APP_ENTRY] = true

        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferencesKKeys.APP_ENTRY] ?: false
        }
    }

}

private val readOnlyProperty = preferencesDataStore(name = USER_SETTING)
val Context.dataStore: DataStore<Preferences> by readOnlyProperty

private object PreferencesKKeys {
    val APP_ENTRY = booleanPreferencesKey(Constants.APP_ENTRY)
}
