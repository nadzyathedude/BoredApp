package boredapp.mobileup.template.core.network

import boredapp.mobileup.template.core.debug_tools.DebugTools
import io.ktor.client.engine.*
import io.ktor.client.engine.okhttp.*

fun createOkHttpEngine(debugTools: DebugTools): HttpClientEngine {
    return OkHttp.create {
        debugTools.interceptors.forEach { addInterceptor(it) }
    }
}
