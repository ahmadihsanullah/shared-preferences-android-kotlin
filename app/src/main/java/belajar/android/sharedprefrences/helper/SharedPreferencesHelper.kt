package belajar.android.sharedprefrences.helper

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesHelper(context: Context) {
    private val PREFS_NAME = "sharepref123"
    val sharedPref : SharedPreferences
    val editor : SharedPreferences.Editor

    init {
        sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        editor = sharedPref.edit()
    }

    fun put(key: String, value: String){
        editor.putString(key,value)
            .apply()
    }
    fun getString(key:String) {
        sharedPref.getString(key, null)
    }
    fun put(key: String, value: Boolean){
        editor.putBoolean(key,value)
            .apply()
    }
    fun getBoolean(key:String) {
        sharedPref.getBoolean(key, false)
    }
}
