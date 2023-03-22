package ru.chelyadinova.features.bored_activities.data

import me.aartikov.replica.keyed.KeyedReplica
import ru.chelyadinova.features.bored_activities.domain.BoredActivity
import ru.chelyadinova.features.bored_activities.domain.BoredActivityTypeValue

interface BoredActivitiesRepository {
    val boredActivityReplica : KeyedReplica<BoredActivityTypeValue, BoredActivity>
}