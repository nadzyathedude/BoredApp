package ru.chelyadinova.features.bored_activities.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.chelyadinova.features.bored_activities.domain.BoredActivityType

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BoredActivityTypeItem(
    type: BoredActivityType,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    onClick: (() -> Unit)? = null
) {
    Surface(
        modifier = modifier,
        onClick = { onClick?.invoke() },
        enabled = onClick != null,
        shape = RoundedCornerShape(48.dp),
        color = when (isSelected) {
            true -> MaterialTheme.colors.primary
            else -> MaterialTheme.colors.surface
        },
        elevation = 6.dp
    ) {
        Text(
            text = type.typeName, style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
        )
    }
}
