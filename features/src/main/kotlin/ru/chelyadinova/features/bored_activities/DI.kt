package ru.chelyadinova.features

import boredapp.mobileup.template.core.ComponentFactory
import boredapp.mobileup.template.core.network.NetworkApiFactory
import com.arkivanov.decompose.ComponentContext
import org.koin.core.component.get
import org.koin.dsl.module
import ru.chelyadinova.features.bored_activities.data.BoredActivitiesRepository
import ru.chelyadinova.features.bored_activities.data.BoredActivitiesRepositoryImpl
import ru.chelyadinova.features.bored_activities.data.BoredApi
import ru.chelyadinova.features.bored_activities.ui.BoredActivitiesComponent
import ru.chelyadinova.features.bored_activities.ui.BoredActivitiesComponentImpl

val boredActivityModule = module {
    single<BoredApi> { get<NetworkApiFactory>().unauthorizedKtorfit.create() }
    single<BoredActivitiesRepository> { BoredActivitiesRepositoryImpl(get(), get()) }
}

fun ComponentFactory.createBoredActivitiesComponent(
    componentContext: ComponentContext
): BoredActivitiesComponent {
    val boredActivityReplica = get<BoredActivitiesRepository>().boredActivityReplica
    return BoredActivitiesComponentImpl(componentContext, boredActivityReplica)
}
