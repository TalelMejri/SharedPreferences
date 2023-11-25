package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences

class sharedPreferncesConfig(val context:Context) {

    private val pref_name ="AppPref";
    val sharedPref: SharedPreferences = context.getSharedPreferences(pref_name, Context.MODE_PRIVATE)

    fun save(key:String,value:Int){
        val editor:SharedPreferences.Editor=sharedPref.edit();
        editor.putInt(key,value);
        editor.commit();//save
    }

    fun save(key:String,value:String){
        val editor:SharedPreferences.Editor=sharedPref.edit();
        editor.putString(key,value);
        editor.commit();
    }

    fun getStringValue(key:String):String?{
        return sharedPref.getString(key,null);
    }

    fun getIntValue(key:String):Int{
        return sharedPref.getInt(key,0);
    }

    fun clearSharedPreference() {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.clear()
        editor.commit()
    }

}