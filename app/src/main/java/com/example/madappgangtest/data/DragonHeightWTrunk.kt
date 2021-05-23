package com.example.madappgangtest.data

import com.google.gson.annotations.SerializedName

data class DragonHeightWTrunk(
    @SerializedName("meters") var metersTrunk: Double,
    @SerializedName("feet") var feetTrunk: Double,
)
