package com.example.madappgangtest.data

import com.google.gson.annotations.SerializedName

data class DragonTrunk(
@SerializedName("trunk_volume") var trunkVolume: DrTrTrunkVolume,
@SerializedName("cargo") var cargo: DrTrCargo,
)
