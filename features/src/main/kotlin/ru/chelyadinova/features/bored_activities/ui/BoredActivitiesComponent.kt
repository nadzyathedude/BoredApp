package ru.chelyadinova.features.bored_activities.ui

import kotlinx.coroutines.flow.StateFlow
import ru.chelyadinova.features.bored_activities.domain.BoredActivityType
import ru.chelyadinova.features.bored_activities.domain.BoredActivityTypeValue

interface BoredActivitiesComponent {
    val types: List<BoredActivityType>

    val selectedTypeId: StateFlow<BoredActivityTypeValue>

    fun onTypeCLick(typeId: BoredActivityTypeValue)

    fun onGetNewActivityIdeaClick()

}