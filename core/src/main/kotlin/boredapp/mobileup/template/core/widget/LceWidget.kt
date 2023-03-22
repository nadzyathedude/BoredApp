package boredapp.mobileup.template.core.widget

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import boredapp.mobileup.template.core.utils.LoadableState
import dev.icerock.moko.resources.compose.localized

/**
 * Displays Replica state ([LoadableState]).
 */
@Composable
fun <T : Any> LceWidget(
    state: LoadableState<T>,
    onRetryClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable (data: T, refreshing: Boolean) -> Unit
) {
    val (loading, data, error) = state
    when {
        data != null -> content(data, loading)

        loading -> FullscreenCircularProgress(modifier)

        error != null -> ErrorPlaceholder(
            errorMessage = error.localized(),
            onRetryClick = onRetryClick,
            modifier = modifier
        )
    }
}
