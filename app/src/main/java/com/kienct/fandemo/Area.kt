package com.kienct.fandemo

import com.google.gson.annotations.SerializedName

data class Area(
    @SerializedName("Key")
    var key: String,
    @SerializedName("LocalizedName")
    var localizedName: String,
    @SerializedName("AdministrativeArea")
    var area: AdministrativeArea,
    @SerializedName("GeoPosition")
    var geoPosition: GeoPosition

)

data class GeoPosition(
    @SerializedName("Latitude")
    var latitude: String,
    @SerializedName("Longitude")
    var longitude: String
)

data class AdministrativeArea(
    @SerializedName("EnglishName")
    var EnglishName: String
)

