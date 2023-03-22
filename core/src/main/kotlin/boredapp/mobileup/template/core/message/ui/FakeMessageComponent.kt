package boredapp.mobileup.template.core.message.ui

import boredapp.mobileup.template.core.message.domain.Message
import dev.icerock.moko.resources.desc.Raw
import dev.icerock.moko.resources.desc.StringDesc
import kotlinx.coroutines.flow.MutableStateFlow

class FakeMessageComponent : MessageComponent {

    override val visibleMessage = MutableStateFlow(
        Message(StringDesc.Raw("Message"))
    )

    override fun onActionClick() = Unit
}
