package com.example.madappgangtest.data

import com.google.gson.annotations.SerializedName

data class DrTrCargo(
    @SerializedName("solar_array") var solarArray:Int,
    @SerializedName("unpressurized_cargo") var unpressurizedCargo: Boolean,
)
