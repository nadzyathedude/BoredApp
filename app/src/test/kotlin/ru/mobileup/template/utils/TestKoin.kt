package ru.mobileup.template.utils

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import me.aartikov.replica.network.NetworkConnectivityProvider
import org.koin.core.Koin
import org.koin.core.context.loadKoinModules
import org.koin.dsl.ModuleDeclaration
import org.koin.dsl.module
import org.koin.test.KoinTestRule
import ru.mobileup.core.ComponentFactory
import ru.mobileup.core.debug_tools.DebugTools
import ru.mobileup.template.App
import ru.mobileup.template.allModules

fun KoinTestRule.testKoin(moduleDeclaration: ModuleDeclaration? = null): Koin {
    val testModule = module {
        single<Context> { ApplicationProvider.getApplicationContext<App>() }
        single { ComponentFactory(koin) }
        single<NetworkConnectivityProvider> { FakeNetworkConnectivityProvider() }
        single<DebugTools> { TestDebugTools() }
        if (moduleDeclaration != null) moduleDeclaration()
    }
    loadKoinModules(allModules + testModule)
    return koin
}

val Koin.componentFactory: ComponentFactory
    get() = this.get()