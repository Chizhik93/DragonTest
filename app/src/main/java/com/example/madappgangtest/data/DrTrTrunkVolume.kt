package com.example.madappgangtest.data

import com.google.gson.annotations.SerializedName

data class DrTrTrunkVolume(
    @SerializedName("cubic_meters") var cubicMeters: Int,
    @SerializedName("cubic_feet") var cubicFeet:Int,
)
