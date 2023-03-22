package ru.chelyadinova.features.bored_activities.data

import boredapp.mobileup.template.core.network.NetworkApiFactory
import me.aartikov.replica.client.ReplicaClient
import me.aartikov.replica.keyed.KeyedPhysicalReplica
import me.aartikov.replica.keyed.KeyedReplica
import me.aartikov.replica.single.ReplicaSettings
import ru.chelyadinova.features.bored_activities.data.dto.toDomain
import ru.chelyadinova.features.bored_activities.domain.BoredActivity
import ru.chelyadinova.features.bored_activities.domain.BoredActivityTypeValue
import kotlin.time.Duration.Companion.seconds

class BoredActivitiesRepositoryImpl(
    replicaClient: ReplicaClient,
    networkApiFactory: NetworkApiFactory
) : BoredActivitiesRepository {

    val api = networkApiFactory.unauthorizedKtorfit.create<BoredApi>()
    override val boredActivityReplica: KeyedPhysicalReplica<BoredActivityTypeValue, BoredActivity> =
        replicaClient.createKeyedReplica(
            name = "activityByType",
            childName = { tydeId -> "typeId = ${tydeId.value}" },
            childSettings = {
                ReplicaSettings(
                    staleTime = 10.seconds,
                    clearTime = 60.seconds
                )
            }) { activityType ->
            api.getActivity(activityType.value).toDomain()
        }
}