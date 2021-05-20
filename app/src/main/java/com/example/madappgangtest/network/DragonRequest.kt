package com.example.madappgangtest.network

import com.example.madappgangtest.data.Dragon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DragonRequest {
    private val mService = RetrofitClient.retrofitService

    fun loadAllDragonList(onResponseDragons: (MutableList<Dragon>?) -> Unit) {
        mService.getMovieList().enqueue(object : Callback<MutableList<Dragon>> {
            override fun onFailure(call: Call<MutableList<Dragon>>, t: Throwable) {
                val i = 0
            }

            override fun onResponse(call: Call<MutableList<Dragon>>, response: Response<MutableList<Dragon>>) {
                val dragonsResult = response.body()
                saveAllDragonList(dragonsResult)
                onResponseDragons(dragonsResult)
            }
        })
    }

    fun saveAllDragonList(dragons: MutableList<Dragon>?){
        // save dragons to room
    }

    fun getAllDragonList(onResponseDragons: (MutableList<Dragon>?) -> Unit) {
        // get dragons from room
    }

    fun getDragonById(onResponseDragons: (Dragon?) -> Unit) {
        // get one dragon from room
    }
}