package ru.chelyadinova.features.bored_activities.ui

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import me.aartikov.replica.keyed.KeyedReplica
import ru.chelyadinova.features.bored_activities.domain.BoredActivity
import ru.chelyadinova.features.bored_activities.domain.BoredActivityType
import ru.chelyadinova.features.bored_activities.domain.BoredActivityTypeValue

class BoredActivitiesComponentImpl(
    componentContext: ComponentContext,
    private val boredActivityReplica: KeyedReplica<BoredActivityTypeValue, BoredActivity>
) : BoredActivitiesComponent{
    override val types: List<BoredActivityType> = listOf(
        BoredActivityType.RANDOM,
        BoredActivityType.EDUCATION,
        BoredActivityType.COOKING,
        BoredActivityType.SOCIAL,
        BoredActivityType.CHARITY,
        BoredActivityType.BUSYWORK,
        BoredActivityType.DIY,
        BoredActivityType.MUSIC,
        BoredActivityType.RECREATIONAL,
        BoredActivityType.RELAXATION
    )

    override val selectedTypeId: StateFlow<BoredActivityTypeValue> = MutableStateFlow(types[0].typeValue)

    override fun onTypeCLick(typeId: BoredActivityTypeValue) {}

    override fun onGetNewActivityIdeaClick() {
        boredActivityReplica.refresh(selectedTypeId.value)
    }

}