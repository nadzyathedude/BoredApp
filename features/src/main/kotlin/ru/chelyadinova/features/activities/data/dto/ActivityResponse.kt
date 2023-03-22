package ru.chelyadinova.features.activities.data.dto

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
class ActivityResponse (
    @SerialName("activity") val activityName: String,
    @SerialName("type") val type: String,
    @SerialName("participants") val participants: Int
    )