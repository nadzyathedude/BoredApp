pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    val kotlinVersion = "1.8.0"
    val androidPluginVersion = "7.4.0"
    val detektVersion = "1.22.0"
    val moduleGraphVersion = "1.3.3"
    val kspVersion = "1.8.0-1.0.9"
    val ktorfitVersion = "1.0.0"
    val mokoResourcesVersion = "0.20.1"

    plugins {
        id("com.android.application") version androidPluginVersion
        id("com.android.library") version androidPluginVersion
        id("io.gitlab.arturbosch.detekt") version detektVersion
        id("ru.mobileup.module-graph") version moduleGraphVersion
        id("org.jetbrains.kotlin.android") version kotlinVersion
        kotlin("plugin.serialization") version kotlinVersion
        kotlin("plugin.parcelize") version kotlinVersion
        id("com.google.devtools.ksp") version kspVersion
        id("de.jensklingenberg.ktorfit") version ktorfitVersion
        id("dev.icerock.mobile.multiplatform-resources") version mokoResourcesVersion
    }
}

rootProject.name = "MobileUp Android Template"

include(":app")
include(":core")
include(":features")

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }

    versionCatalogs {
        create("libs") {

            // Kotlin
            val dateTimeVersion = "0.4.0"
            library("kotlinx-datetime", "org.jetbrains.kotlinx", "kotlinx-datetime").version(
                dateTimeVersion
            )

            // Concurrency
            val coroutinesVersion = "1.6.4"
            library("coroutines-core", "org.jetbrains.kotlinx", "kotlinx-coroutines-core").version(
                coroutinesVersion
            )
            library(
                "coroutines-android",
                "org.jetbrains.kotlinx",
                "kotlinx-coroutines-android"
            ).version(coroutinesVersion)

            // Architecture
            val decomposeVersion = "0.8.0"
            library("decompose-core", "com.arkivanov.decompose", "decompose").version(
                decomposeVersion
            )
            library(
                "decompose-compose",
                "com.arkivanov.decompose",
                "extensions-compose-jetpack"
            ).version(decomposeVersion)
            bundle("decompose", listOf("decompose-core", "decompose-compose"))

            // Network
            val ktorVersion = "2.2.2"
            val ktorfitVersion = "1.0.0-beta17"
            library("ktor-core", "io.ktor", "ktor-client-core").version(ktorVersion)
            library("ktor-auth", "io.ktor", "ktor-client-auth").version(ktorVersion)
            library("ktor-serialization", "io.ktor", "ktor-serialization-kotlinx-json").version(
                ktorVersion
            )
            library(
                "ktor-content-negotiation",
                "io.ktor",
                "ktor-client-content-negotiation"
            ).version(ktorVersion)
            library("ktor-logging", "io.ktor", "ktor-client-logging").version(ktorVersion)
            library("ktor-android", "io.ktor", "ktor-client-okhttp").version(ktorVersion)
            library("ktorfit-lib", "de.jensklingenberg.ktorfit", "ktorfit-lib").version(
                ktorfitVersion
            )
            library("ktorfit-ksp", "de.jensklingenberg.ktorfit", "ktorfit-ksp").version(
                ktorfitVersion
            )
            bundle(
                "ktor",
                listOf(
                    "ktor-core",
                    "ktor-auth",
                    "ktor-serialization",
                    "ktor-content-negotiation",
                    "ktor-logging",
                    "ktor-android"
                )
            )

            // Replica
            val replicaVersion = "1.0.0-alpha10"
            library("replica-core", "com.github.aartikov", "replica-core").version(replicaVersion)
            library("replica-algebra", "com.github.aartikov", "replica-algebra").version(
                replicaVersion
            )
            library(
                "replica-android-network",
                "com.github.aartikov",
                "replica-android-network"
            ).version(replicaVersion)
            library("replica-decompose", "com.github.aartikov", "replica-decompose").version(
                replicaVersion
            )
            library("replica-devtools", "com.github.aartikov", "replica-devtools").version(
                replicaVersion
            )
            bundle(
                "replica",
                listOf(
                    "replica-core",
                    "replica-algebra",
                    "replica-android-network",
                    "replica-decompose"
                )
            )

            // Serialization
            val serializationVersion = "1.3.3"
            library(
                "serialization-json",
                "org.jetbrains.kotlinx",
                "kotlinx-serialization-json"
            ).version(serializationVersion)

            // DI
            val koinVersion = "3.2.0"
            library("koin", "io.insert-koin", "koin-core").version(koinVersion)

            // Logging
            val kermitVersion = "1.2.2"
            library("logger-kermit", "co.touchlab", "kermit").version(kermitVersion)

            // Code quality
            val detectVersion = "1.21.0"
            library(
                "detekt-formatting",
                "io.gitlab.arturbosch.detekt",
                "detekt-formatting"
            ).version(detectVersion)

            // Android
            val androidDesugarVersion = "1.1.5"
            val lifecycleProcessVersion = "2.4.0"
            library("android-desugar", "com.android.tools", "desugar_jdk_libs").version(
                androidDesugarVersion
            )
            library(
                "androidx-lifecycle-process",
                "androidx.lifecycle",
                "lifecycle-process"
            ).version(lifecycleProcessVersion)

            // Android UI
            val composeVersion = "1.4.0-beta02"
            version("composeCompiler", "1.4.0")
            val activityComposeVersion = "1.6.1"
            val activityVersion = "1.6.1"
            val coilVersion = "2.1.0"
            val splashscreenVersion = "1.0.0"
            val accompanistVersion = "0.24.13-rc"
            library("compose-ui", "androidx.compose.ui", "ui").version(composeVersion)
            library("compose-material", "androidx.compose.material", "material").version(
                composeVersion
            )
            library("compose-tooling", "androidx.compose.ui", "ui-tooling").version(composeVersion)
            library("activity-compose", "androidx.activity", "activity-compose").version(
                activityComposeVersion
            )
            library("activity", "androidx.activity", "activity-ktx").version(activityVersion)
            bundle(
                "compose",
                listOf(
                    "compose-ui",
                    "compose-material",
                    "compose-tooling",
                    "activity-compose"
                )
            )

            library("coil", "io.coil-kt", "coil-compose").version(coilVersion)
            library("splashscreen", "androidx.core", "core-splashscreen").version(
                splashscreenVersion
            )

            library(
                "accompanist-systemuicontroller",
                "com.google.accompanist",
                "accompanist-systemuicontroller"
            ).version(accompanistVersion)
            library(
                "accompanist-swiperefresh",
                "com.google.accompanist",
                "accompanist-swiperefresh"
            ).version(accompanistVersion)
            bundle(
                "accompanist",
                listOf(
                    "accompanist-systemuicontroller",
                    "accompanist-swiperefresh",
                )
            )

            // Resources
            val mokoResourcesVersion = "0.20.1"
            library("moko-resources", "dev.icerock.moko", "resources").version(mokoResourcesVersion)
            library("moko-resourcesCompose", "dev.icerock.moko", "resources-compose").version(
                mokoResourcesVersion
            )

            // Debug tools
            val chuckerVersion = "3.5.2"
            val hyperionVersion = "0.9.34"
            val hyperionAddonsVersion = "0.3.3"
            library("chucker", "com.github.chuckerteam.chucker", "library").version(chuckerVersion)
            library("hyperion-core", "com.willowtreeapps.hyperion", "hyperion-core").version(
                hyperionVersion
            )
            library(
                "hyperion-recorder",
                "com.willowtreeapps.hyperion",
                "hyperion-recorder"
            ).version(hyperionVersion)
            library("hyperion-crash", "com.willowtreeapps.hyperion", "hyperion-crash").version(
                hyperionVersion
            )
            library("hyperion-disk", "com.willowtreeapps.hyperion", "hyperion-disk").version(
                hyperionVersion
            )
            library("hyperion-addons-logs", "me.nemiron.hyperion", "logs").version(
                hyperionAddonsVersion
            )
            library(
                "hyperion-addons-networkEmulation",
                "me.nemiron.hyperion",
                "network-emulation"
            ).version(hyperionAddonsVersion)
            library("hyperion-addons-chucker", "me.nemiron.hyperion", "chucker").version(
                hyperionAddonsVersion
            )
            bundle("hyperion", listOf("hyperion-core", "hyperion-recorder", "hyperion-crash", "hyperion-disk", "hyperion-addons-logs", "hyperion-addons-networkEmulation", "hyperion-addons-chucker"))

            // Testing
            library("junit", "junit", "junit").version("4.13.2")
            library("extJunit", "androidx.test.ext", "junit-ktx").version("1.1.3")
            library("kotlinTest", "org.jetbrains.kotlin", "kotlin-test").version("1.7.10")
            library("mockWebServer", "com.squareup.okhttp3", "mockwebserver").version("4.3.1")
            library("awaitility", "org.awaitility", "awaitility-kotlin").version("4.2.0")
            library("robolectric", "org.robolectric", "robolectric").version("4.8")
        }
    }
}
