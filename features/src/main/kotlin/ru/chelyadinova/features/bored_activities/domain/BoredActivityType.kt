package ru.chelyadinova.features.bored_activities.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
@JvmInline
value class BoredActivityTypeValue(val value: String) : Parcelable
data class BoredActivityType(val typeValue: BoredActivityTypeValue, val typeName : String) {
    companion object {
        val RANDOM = BoredActivityType(typeValue = BoredActivityTypeValue(value = ""), typeName = "Random")
        val EDUCATION = BoredActivityType(typeValue = BoredActivityTypeValue(value = "education"), typeName ="Education")
        val RECREATIONAL = BoredActivityType(typeValue = BoredActivityTypeValue(value = "recreational"), typeName ="Recreational" )
        val SOCIAL = BoredActivityType(typeValue = BoredActivityTypeValue(value = "social"), typeName = " Social")
        val DIY = BoredActivityType(typeValue = BoredActivityTypeValue(value = "diy"), typeName = "DIY")
        val CHARITY = BoredActivityType(typeValue = BoredActivityTypeValue(value = "charity"), typeName = "Charity")
        val COOKING = BoredActivityType(typeValue = BoredActivityTypeValue(value = "cooking"), typeName = "Cooking")
        val RELAXATION = BoredActivityType(typeValue = BoredActivityTypeValue(value = "relaxation"), typeName = "Relaxation")
        val MUSIC = BoredActivityType(typeValue = BoredActivityTypeValue(value = "music"), typeName = "Music")
        val BUSYWORK = BoredActivityType(typeValue = BoredActivityTypeValue(value = "busywork"), typeName = "Busy work")
    }
}