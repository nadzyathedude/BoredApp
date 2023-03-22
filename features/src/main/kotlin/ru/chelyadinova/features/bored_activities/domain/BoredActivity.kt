package ru.chelyadinova.features.bored_activities.domain

data class BoredActivity (
    val activityName : String,
    val type: String,
    val participantsAmount : Int
    )