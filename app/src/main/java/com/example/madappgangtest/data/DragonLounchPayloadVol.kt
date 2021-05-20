package com.example.madappgangtest.data

import com.google.gson.annotations.SerializedName

data class DragonLounchPayloadVol(
    @SerializedName("cubic_meters") var cubicMeters: Int,
    @SerializedName("cubic_feet") var cubicFeet: Int,
)
