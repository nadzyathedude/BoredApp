package boredapp.mobileup.template

import boredapp.mobileup.template.core.coreModule
import ru.chelyadinova.features.boredActivityModule
import ru.mobileup.template.BuildConfig

val allModules = listOf(
    coreModule(BuildConfig.BACKEND_URL),
    boredActivityModule
)