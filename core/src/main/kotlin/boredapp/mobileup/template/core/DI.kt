package boredapp.mobileup.template.core

import boredapp.mobileup.template.core.activity.ActivityProvider
import boredapp.mobileup.template.core.debug_tools.DebugTools
import boredapp.mobileup.template.core.debug_tools.RealDebugTools
import boredapp.mobileup.template.core.error_handling.ErrorHandler
import boredapp.mobileup.template.core.message.data.MessageService
import boredapp.mobileup.template.core.message.data.MessageServiceImpl
import boredapp.mobileup.template.core.message.ui.MessageComponent
import boredapp.mobileup.template.core.message.ui.RealMessageComponent
import boredapp.mobileup.template.core.network.ErrorCollector
import boredapp.mobileup.template.core.network.NetworkApiFactory
import boredapp.mobileup.template.core.network.createOkHttpEngine
import boredapp.mobileup.template.core.permissions.PermissionService
import com.arkivanov.decompose.BuildConfig
import com.arkivanov.decompose.ComponentContext
import me.aartikov.replica.client.ReplicaClient
import me.aartikov.replica.network.AndroidNetworkConnectivityProvider
import me.aartikov.replica.network.NetworkConnectivityProvider
import org.koin.core.component.get
import org.koin.dsl.module

fun coreModule(backendUrl: String) = module {
    single { ActivityProvider() }
    single<NetworkConnectivityProvider> { AndroidNetworkConnectivityProvider(get()) }
    single { ReplicaClient(get()) }
    single<MessageService> { MessageServiceImpl() }
    single { ErrorHandler(get()) }
    single<DebugTools> { RealDebugTools(get(), get()) }
    single { createOkHttpEngine(get()) }
    single {
        NetworkApiFactory(
            loggingEnabled = BuildConfig.DEBUG,
            backendUrl = backendUrl,
            httpClientEngine = get(),
            errorCollector = get()
        )
    }
    single {
        val debugTools = get<DebugTools>()
        ErrorCollector { debugTools.collectNetworkError(it) }
    }
    single(createdAtStart = true) { PermissionService(get(), get()) }
}

fun ComponentFactory.createMessageComponent(
    componentContext: ComponentContext
): MessageComponent {
    return RealMessageComponent(componentContext, get())
}
