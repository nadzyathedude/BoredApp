package boredapp.mobileup.template.core.message.data

import boredapp.mobileup.template.core.message.domain.Message
import kotlinx.coroutines.flow.Flow

/**
 * A service for centralized message showing
 */
interface MessageService {

    val messageFlow: Flow<Message>

    fun showMessage(message: Message)
}