package com.example.madappgangtest.data

import androidx.room.*
import com.example.madappgangtest.database.ListStringConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "dragons", primaryKeys = ["id"])
data class Dragon(
    //@PrimaryKey
    @SerializedName("id") var id: String,


    @SerializedName("name") var name: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("active") var active: Boolean? = null,
    @SerializedName("crew_capacity") var crewCapacity: Int? = null,
    @SerializedName("sidewall_angle_deg") var sidewallAngledeg: Int? = null,
    @SerializedName("orbit_duration_yr") var orbitDurationYr: Int? = null,
    @SerializedName("dry_mass_kg") var dryMassKg: Int? = null,
    @SerializedName("dry_mass_lb") var dryMassLb: Int? = null,
    @SerializedName("first_flight") var firstFlight: String? = null,
    @SerializedName("wikipedia") var wikipidia: String? = null,
    @SerializedName("description") var description: String? = null,


    //@SerializedName("heat_shield") var heatShield: DragonHeatShield,
    //@SerializedName("launch_payload_mass") var lounchPayloadMass: DragonLounchPayloadMass,
    //@SerializedName("launch_payload_vol") var lounchPayloadVol: DragonLounchPayloadVol,
    //@SerializedName("return_payload_mass") var returnPayloadMass: DragonReturnPayloadMass,
    //@SerializedName("return_payload_vol") var returnPayloadVol: DragonReturnPayloadVol,
    //@SerializedName("pressurized_capsule") var pressurizedCapsule: DragonPressurizedCapsule,
    //@SerializedName("trunk") var trunk: DragonTrunk,
    @Embedded
    @SerializedName("height_w_trunk") var heightWTrunk: DragonHeightWTrunk,
    //@SerializedName("diameter") var diametr: DragonDiametr,
    @TypeConverters(ListStringConverter::class)
    @SerializedName("flickr_images") var flickrImages: List<String>,
    //@SerializedName("thrusters") var thrusters: List<DragonThrusters>,

    )

