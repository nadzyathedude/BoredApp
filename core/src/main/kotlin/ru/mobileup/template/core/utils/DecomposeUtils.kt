package ru.mobileup.template.core.utils

import android.os.Parcelable
import androidx.compose.runtime.State
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.doOnDestroy
import com.arkivanov.essenty.statekeeper.StateKeeperOwner
import com.arkivanov.essenty.statekeeper.consume
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import me.aartikov.replica.decompose.coroutineScope

/**
 * Creates a [ChildStack] with a single active component. Should be used to create a stack for Jetpack Compose preview.
 */
fun <T : Any> createFakeChildStack(instance: T): ChildStack<*, T> {
    return ChildStack(
        configuration = "<fake>",
        instance = instance
    )
}

fun <T : Any> createFakeChildStackStateFlow(instance: T): StateFlow<ChildStack<*, T>> {
    return MutableStateFlow(createFakeChildStack(instance))
}

/**
 * Converts [Value] from Decompose to [State] from Jetpack Compose.
 */
fun <T : Any> Value<T>.toStateFlow(lifecycle: Lifecycle): StateFlow<T> {
    val state: MutableStateFlow<T> = MutableStateFlow(this.value)

    if (lifecycle.state != Lifecycle.State.DESTROYED) {
        val observer = { value: T -> state.value = value }
        subscribe(observer)
        lifecycle.doOnDestroy {
            unsubscribe(observer)
        }
    }

    return state
}

/**
 * Creates a coroutine scope tied to Decompose lifecycle. A scope is canceled when a component is destroyed.
 */
val ComponentContext.componentScope: CoroutineScope
    get() {
        val scope = (instanceKeeper.get(ComponentScopeKey) as? CoroutineScopeWrapper)?.scope
        if (scope != null) return scope

        val newScope = lifecycle.coroutineScope()
        instanceKeeper.put(ComponentScopeKey, CoroutineScopeWrapper(newScope))
        return newScope
    }

private object ComponentScopeKey

private class CoroutineScopeWrapper(val scope: CoroutineScope) : InstanceKeeper.Instance {
    override fun onDestroy() {
        // nothing
    }
}

/**
 * A helper function to save and restore component state.
 */
inline fun <reified T : Parcelable> StateKeeperOwner.persistent(
    key: String = "PersistentState",
    noinline save: () -> T,
    restore: (T) -> Unit
) {
    stateKeeper.consume<T>(key)?.run(restore)
    stateKeeper.register(key, save)
}
