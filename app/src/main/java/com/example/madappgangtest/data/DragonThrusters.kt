package com.example.madappgangtest.data

import com.google.gson.annotations.SerializedName

data class DragonThrusters(
    @SerializedName("type") var type: String,
    @SerializedName("amount") var amount: Int,
    @SerializedName("pods") var pods: Int,
    @SerializedName("fuel_1") var fuel1: String,
    @SerializedName("fuel_2") var fuel2: String,
    @SerializedName("isp") var isp: Int,
    @SerializedName("thrust") var thrust: DrThThrust,
)
