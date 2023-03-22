package boredapp.mobileup.template.core.message.data

import boredapp.mobileup.template.core.message.domain.Message
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

class MessageServiceImpl : MessageService {

    private val messageChannel = Channel<Message>(Channel.UNLIMITED)

    override val messageFlow = messageChannel.receiveAsFlow()

    override fun showMessage(message: Message) {
        messageChannel.trySend(message)
    }
}