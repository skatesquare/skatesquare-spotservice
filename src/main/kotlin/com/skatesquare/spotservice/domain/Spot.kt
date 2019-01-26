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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Spot

        if (id != other.id) return false
        if (name != other.name) return false
        if (description != other.description) return false
        if (indoor != other.indoor) return false
        if (type != other.type) return false
        if (material != other.material) return false
        if (latitude != other.latitude) return false
        if (longitude != other.longitude) return false
        if (createdByUserId != other.createdByUserId) return false
        if (!features.contentEquals(other.features)) return false
        if (!openingHours.contentEquals(other.openingHours)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + indoor.hashCode()
        result = 31 * result + type.hashCode()
        result = 31 * result + material.hashCode()
        result = 31 * result + latitude.hashCode()
        result = 31 * result + longitude.hashCode()
        result = 31 * result + createdByUserId.hashCode()
        result = 31 * result + features.contentHashCode()
        result = 31 * result + openingHours.contentHashCode()
        return result
    }
}