package com.example.madappgangtest.data

import com.google.gson.annotations.SerializedName

data class DragonLounchPayloadMass(
    @SerializedName("kg") var kg: Int,
    @SerializedName("lb") var lb: Int
)
