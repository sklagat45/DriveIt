package com.sklagat46.driveit.data.local

import android.content.SharedPreferences
import com.google.gson.Gson
import com.sklagat46.driveit.models.LoginResponse


/**
 * Settings entity.
 */
class Settings
constructor(private val settings: SharedPreferences) {
    private val PREF_KEY_CLIENT_INFO = "client_info"

    /**
     * isloggedIn
     */
    fun isloggedIn(): Boolean {
        return settings.getBoolean("is_logged_in", false)
    }

    /**
     * setIsloggedIn
     */
    fun setIsloggedIn(isloggedin: Boolean) {
        val editor = settings.edit()
        editor.putBoolean("is_logged_in", isloggedin)
        editor.apply()
    }

    /**
     * getAuth
     */
    fun getAuth(): LoginResponse? {
        val gson = Gson()
        val userJson = settings.getString("auth", null)
        return if (userJson == null) {
            return null
        } else {
            gson.fromJson<LoginResponse>(userJson, LoginResponse::class.java)
        }
    }

    /**
     * setAuth
     */
    fun setAuth(data: LoginResponse?) {
        val gson = Gson()
        val json = gson.toJson(data)
        val editor = settings.edit()
        editor.putString("auth", json)
        editor.apply()
    }



}