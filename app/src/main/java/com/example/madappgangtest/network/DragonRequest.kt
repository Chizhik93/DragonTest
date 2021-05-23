package com.example.madappgangtest.network

import android.content.Context
import androidx.room.Room
import com.example.madappgangtest.data.Dragon
import com.example.madappgangtest.database.DragonDatabase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DragonRequest(applicationContext: Context) {
    private val mService = RetrofitClient.retrofitService
    val db = Room.databaseBuilder(
        applicationContext,
        DragonDatabase::class.java, "dragonsDatabase"
    ).allowMainThreadQueries().build()
    val dragonDao = db.dragonDao()

    fun loadAllDragonList(onResponseDragons: (MutableList<Dragon>?) -> Unit) {
        mService.getMovieList().enqueue(object : Callback<MutableList<Dragon>> {
            override fun onFailure(call: Call<MutableList<Dragon>>, t: Throwable) {
                val i = 0
            }

            override fun onResponse(
                call: Call<MutableList<Dragon>>,
                response: Response<MutableList<Dragon>>
            ) {
                val dragonsResult = response.body()
                saveAllDragonList(dragonsResult)
                onResponseDragons(dragonsResult)
            }
        })
    }

    fun saveAllDragonList(dragons: MutableList<Dragon>?) {
        // save dragons to room
        if (dragons != null) {
            dragonDao.insertAll(dragons)
        }
    }

    fun getAllDragonList(): MutableList<Dragon> {
        // get dragons from room
        return dragonDao.getAll()
    }

    fun getDragonById(dragonId: String): Dragon {
        // get one dragon from room
        return dragonDao.getDragonById(dragonId)
    }
}