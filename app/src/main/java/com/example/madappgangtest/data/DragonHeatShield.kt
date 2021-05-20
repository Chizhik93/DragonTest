package com.example.madappgangtest.data

import com.google.gson.annotations.SerializedName

data class DragonHeatShield(
    @SerializedName("material") var material: String? = null,
    @SerializedName("dev_partner") var devPartner: String? = null,
    @SerializedName("temp_degrees") var tempDegress: Int? = null,
    @SerializedName("size_meters") var sizeMeters: Double? = null
)
