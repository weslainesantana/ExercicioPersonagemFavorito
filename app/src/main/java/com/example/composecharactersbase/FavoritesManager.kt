package com.example.composecharactersbase

import android.content.Context
import android.content.SharedPreferences

object FavoritesManager {
    private const val PREF_NAME = "favorites"
    private const val KEY_FAVORITES = "favorite_ids"

    private fun getPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun toggleFavorite(context: Context, characterId: Int) {
        val prefs = getPrefs(context)
        val current = getFavorites(context).toMutableSet()
        if (current.contains(characterId.toString())) {
            current.remove(characterId.toString())
        } else {
            current.add(characterId.toString())
        }
        prefs.edit().putStringSet(KEY_FAVORITES, current).apply()
    }

    fun getFavorites(context: Context): Set<String> {
        return getPrefs(context).getStringSet(KEY_FAVORITES, emptySet()) ?: emptySet()
    }

    fun isFavorite(context: Context, characterId: Int): Boolean {
        return getFavorites(context).contains(characterId.toString())
    }
}