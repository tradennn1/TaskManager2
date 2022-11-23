package com.tradennn1.taskmanager2

import android.content.Context

class Prefs(context: Context){
    private val preferences=context.getSharedPreferences("settings",Context.MODE_PRIVATE)

    fun saveState() {
        preferences.edit().putBoolean("isShown",true).apply()
    }
    fun isShown():Boolean{
        return preferences.getBoolean("isShown",false)
    }
    fun saveAges(toString: String){
        preferences.edit().putString("name",null).apply()
    }
    fun getAge():String?{
        return preferences.getString("name",null)
    }
    fun saveImage(image:String) {
        preferences.edit().putString("image",image).apply()
    }

    fun getImage():String?{
        return preferences.getString("image","")
    }



}