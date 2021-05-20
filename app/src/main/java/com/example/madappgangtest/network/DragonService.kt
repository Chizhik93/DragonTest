package com.example.madappgangtest.network

import com.example.madappgangtest.data.Dragon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DragonService {
    @GET("dragons")
    fun getMovieList(): Call<MutableList<Dragon>>
}