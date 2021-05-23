package com.example.madappgangtest.database

import androidx.room.*
import com.example.madappgangtest.data.Dragon

@Dao
abstract class DragonDao {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAll(dragon: List<Dragon>)

    @Query("SELECT * FROM dragons")
    abstract fun getAll(): MutableList<Dragon>

    @Delete
    abstract fun delete(dragon: Dragon)

    @Update
    abstract fun updateDragon (dragon: Dragon)

    @Query("SELECT * FROM dragons WHERE id IN (:dragonId)")
    abstract fun getDragonById(dragonId: String): Dragon
}