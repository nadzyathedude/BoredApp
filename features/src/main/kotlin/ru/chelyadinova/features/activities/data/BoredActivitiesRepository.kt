package ru.chelyadinova.features.activities.data

import me.aartikov.replica.single.Replica
import ru.chelyadinova.features.activities.domain.BoredActivity

interface BoredActivitiesRepository {
    val boredActivityReplica : Replica<BoredActivity>
}