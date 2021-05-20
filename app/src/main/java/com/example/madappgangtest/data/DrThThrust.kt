package com.example.madappgangtest.data

import com.google.gson.annotations.SerializedName

data class DrThThrust(
    @SerializedName("kN") var kN: Double,
    @SerializedName("lbf") var lbf: Int,
)
