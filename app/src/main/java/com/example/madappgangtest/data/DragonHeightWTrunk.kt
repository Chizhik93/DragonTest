package com.example.madappgangtest.data

import com.google.gson.annotations.SerializedName

data class DragonHeightWTrunk(
    @SerializedName("meters") var meters: Double,
    @SerializedName("feet") var feet: Double,
)
