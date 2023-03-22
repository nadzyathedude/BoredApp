package boredapp.mobileup.template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import boredapp.mobileup.template.core.ComponentFactory
import boredapp.mobileup.template.core.activity.ActivityProvider
import boredapp.mobileup.template.core.koin
import boredapp.mobileup.template.core.theme.AppTheme
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.essenty.lifecycle.asEssentyLifecycle
import com.arkivanov.essenty.lifecycle.doOnDestroy
import ru.chelyadinova.features.bored_activities.ui.BoredActivitiesUi
import ru.chelyadinova.features.createBoredActivitiesComponent

// Note: rootComponent survives configuration changes due to "android:configChanges" setting in the manifest.
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)



        val activityProvider = application.koin.get<ActivityProvider>()
        activityProvider.attachActivity(this)
        lifecycle.asEssentyLifecycle().doOnDestroy {
            activityProvider.detachActivity()
        }

        val componentFactory = application.koin.get<ComponentFactory>()
        val rootComponent = componentFactory.createBoredActivitiesComponent(defaultComponentContext())

        setContent {
            AppTheme {
                BoredActivitiesUi(rootComponent)
            }
        }
    }
}
