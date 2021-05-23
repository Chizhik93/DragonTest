package com.example.madappgangtest.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import org.json.JSONArray

class ListStringConverter {
    companion object {
        private val gson = Gson()

        @TypeConverter
        @JvmStatic
        fun stringToList(data: String?): List<String>? {
            val result = mutableListOf<String>()
            if (data == null || data == "null") return result
            val array = JSONArray(data)
            for (i in 0 until array.length()) {
                result.add(array[i].toString())
            }
            return result
        }

        @TypeConverter
        @JvmStatic
        fun listToString(list: List<String>?): String? {
            return gson.toJson(list)
        }
    }
}