package ru.chelyadinova.features.activities.data

import boredapp.mobileup.template.core.network.NetworkApiFactory
import me.aartikov.replica.client.ReplicaClient
import me.aartikov.replica.single.Replica
import me.aartikov.replica.single.ReplicaSettings
import ru.chelyadinova.features.activities.data.dto.toDomain
import ru.chelyadinova.features.activities.domain.BoredActivity
import kotlin.time.Duration.Companion.seconds

class BoredActivitiesRepositoryImpl(
    replicaClient: ReplicaClient,
    networkApiFactory: NetworkApiFactory
) : BoredActivitiesRepository {

    val api = networkApiFactory.unauthorizedKtorfit.create<BoredApi>()
    override val boredActivityReplica: Replica<BoredActivity> =
            replicaClient.createReplica(
                name = "boredActivities",
                settings = ReplicaSettings(
                    staleTime = 10.seconds,
                    clearTime = 60.seconds
                ),
                fetcher = {api.getActivity().toDomain()}
            )
}