package ru.chelyadinova.features

import boredapp.mobileup.template.core.network.NetworkApiFactory
import org.koin.dsl.module
import ru.chelyadinova.features.bored_activities.data.BoredActivitiesRepository
import ru.chelyadinova.features.bored_activities.data.BoredActivitiesRepositoryImpl
import ru.chelyadinova.features.bored_activities.data.BoredApi

val boredActivityModule = module {
    single <BoredApi>{ get<NetworkApiFactory>().unauthorizedKtorfit.create() }
    single<BoredActivitiesRepository>{BoredActivitiesRepositoryImpl(get(), get())}
}