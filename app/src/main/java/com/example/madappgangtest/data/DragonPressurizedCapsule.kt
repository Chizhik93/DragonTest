package com.example.madappgangtest.data

import com.google.gson.annotations.SerializedName

data class DragonPressurizedCapsule(
    @SerializedName("payload_volume") var payloadVolume: PayloadVolume
)
