package ru.chelyadinova.features.activities.domain

data class BoredActivity (
    val activityName : String,
    val type: BoredActivityType,
    val participantsAmount : Int
    )