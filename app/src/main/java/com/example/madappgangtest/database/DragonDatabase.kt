package com.example.madappgangtest.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.madappgangtest.data.Dragon


@Database(entities = [Dragon::class], version = 3, exportSchema = false)
@TypeConverters(ListStringConverter::class)
abstract class DragonDatabase : RoomDatabase(){
    abstract fun dragonDao(): DragonDao
}