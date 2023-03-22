package boredapp.mobileup.template.core.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        // TODO: add authorization headers, refresh token on unauthorized error.
        return chain.proceed(chain.request())
    }
}