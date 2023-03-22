package boredapp.mobileup.template

import android.app.Application
import android.content.Context
import boredapp.mobileup.template.core.ComponentFactory
import boredapp.mobileup.template.core.KoinProvider
import boredapp.mobileup.template.core.debug_tools.DebugTools
import co.touchlab.kermit.BuildConfig
import co.touchlab.kermit.Logger
import co.touchlab.kermit.Severity
import org.koin.core.Koin


class App : Application(), KoinProvider {

    override lateinit var koin: Koin
        private set

    override fun onCreate() {
        super.onCreate()
        initLogger()
        koin = createKoin()
        launchDebugTools()
    }

    private fun initLogger() {
        if (!BuildConfig.DEBUG) {
            Logger.setMinSeverity(Severity.Assert)
        }
    }

    private fun createKoin(): Koin {
        return Koin().apply {
            loadModules(boredapp.mobileup.template.allModules)
            declare(this@App as Application)
            declare(this@App as Context)
            declare(ComponentFactory(this))
            createEagerInstances()
        }
    }

    private fun launchDebugTools() {
        koin.get<DebugTools>().launch()
    }
}
