package com.example.madappgangtest.data

import com.google.gson.annotations.SerializedName

data class DragonReturnPayloadMass(
    @SerializedName("kg") var kg: Int,
    @SerializedName("lb") var lb: Int,
)
