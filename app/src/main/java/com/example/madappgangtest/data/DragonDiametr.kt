package com.example.madappgangtest.data

import com.google.gson.annotations.SerializedName

data class DragonDiametr(
    @SerializedName("meters") var metersDiameter: Double,
    @SerializedName("feet") var feetDiameter: Int,
)
