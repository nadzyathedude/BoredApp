package ru.chelyadinova.features.bored_activities.data

import me.aartikov.replica.single.Replica
import ru.chelyadinova.features.bored_activities.domain.BoredActivity

interface BoredActivitiesRepository {
    val boredActivityReplica : Replica<BoredActivity>
}