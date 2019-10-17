package com.skatesquare.spotservice.domain

import com.fasterxml.jackson.annotation.JsonCreator
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

//data class JsonSpot @JsonCreator constructor(
//        var name: String,
//        var description: String,
//        var indoor: Boolean,
//        var type: SpotType,
//        var material: Material,
//        var latitude: Float,
//        var longitude: Float,
//        var features: Array<Feature> = emptyArray(),
//        var openingHours: Array<OpeningHours> = emptyArray()
//)

@Document
data class Spot(
        @Id var id: String? = null,
        var name: String,
        var description: String,
        var indoor: Boolean,
        var type: SpotType,
        var material: Material,
        var latitude: Float,
        var longitude: Float,
        var createdByUserId: Long,
        var features: Array<Feature> = emptyArray(),
        var openingHours: Array<OpeningHours> = emptyArray()
) {
    companion object {
        fun from(s: Spot) =
                Spot(null, s.name, s.description, s.indoor, s.type, s.material, s.latitude, s.longitude, 1, s.features, s.openingHours)
    }

    fun copyValuesFrom(jsonSpot: Spot) {
        name = jsonSpot.name
        description = jsonSpot.description
        indoor = jsonSpot.indoor
        type = jsonSpot.type
        material = jsonSpot.material
        latitude = jsonSpot.latitude
        longitude = jsonSpot.longitude
        createdByUserId = 1 // TODO get requesting user
        features = jsonSpot.features
        openingHours = jsonSpot.openingHours
    }
}