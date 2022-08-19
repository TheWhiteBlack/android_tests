package com.example.ridery.presentation.session

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.ridery.data.room.entities.User
import com.example.ridery.presentation.App
import com.google.gson.Gson


class CurrentUser private constructor() {
    private var sharedPreferences: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null

    init {
        sharedPreferences = App.getContext().getSharedPreferences(
            PREFERENCES_NAME,
            SHARED_PREFERENCES_MODE
        )
        editor = sharedPreferences!!.edit()
    }

    fun getCurrentUser() : User? {
        val gson = Gson()
        val json = sharedPreferences!!.getString(USER_KEY, "")
        return gson.fromJson(json, User::class.java)
    }

    fun setCurrentUser(user: User) {
        val gson = Gson()
        val json = gson.toJson(user)
        editor!!.putString(USER_KEY, json).apply()
    }

    fun logOut(){
        sharedPreferences!!.edit().clear().apply()
    }

    companion object {

        private const val SHARED_PREFERENCES_MODE: Int = MODE_PRIVATE
        private const val PREFERENCES_NAME = "CurrentUserData"
        private const val USER_KEY = "user"
        private var instance: CurrentUser? = null

        fun getInstance() : CurrentUser{
            if(instance == null){
                instance = CurrentUser()
            }
            return instance!!
        }

    }
}