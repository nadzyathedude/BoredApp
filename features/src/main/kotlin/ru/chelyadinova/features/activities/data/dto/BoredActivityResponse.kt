package ru.chelyadinova.features.activities.data.dto

import kotlinx.serialization.SerialName
import ru.chelyadinova.features.activities.domain.BoredActivity

@kotlinx.serialization.Serializable
class BoredActivityResponse (
    @SerialName("activity") val activityName: String,
    @SerialName("type") val type: String,
    @SerialName("participants") val participantsAmount: Int
    )

fun BoredActivityResponse.toDomain():BoredActivity{
    return BoredActivity(
        activityName = activityName,
        type = type,
        participantsAmount = participantsAmount
    )
}