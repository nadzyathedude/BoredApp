package boredapp.mobileup.template.core.network

import boredapp.mobileup.template.core.error_handling.ApplicationException

fun interface ErrorCollector {
    fun collectNetworkError(exception: ApplicationException)
}
