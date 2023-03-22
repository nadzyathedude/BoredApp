package ru.chelyadinova.features.activities.domain

data class BoredActivityType (val type : String) {
    companion object{
        val RANDOM = BoredActivityType(type = "")
        val EDUCATION = BoredActivityType(type = "education")
        val RECREATIONAL = BoredActivityType(type = "recreational")
        val SOCIAL = BoredActivityType(type = "social")
        val DIY=  BoredActivityType(type = "diy")
        val CHARITY = BoredActivityType(type = "charity")
        val COOKING = BoredActivityType(type = "cooking")
        val RELAXATION = BoredActivityType(type = "relaxation")
        val MUSIC = BoredActivityType(type = "music")
        val BUSYWORK = BoredActivityType(type = "busywork")
    }
}