package ru.chelyadinova.features.bored_activities.ui

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.chelyadinova.features.bored_activities.domain.BoredActivityType
import ru.chelyadinova.features.bored_activities.domain.BoredActivityTypeValue
import ru.mobileup.template.features.R

@Composable
fun BoredActivitiesUi(
    component: BoredActivitiesComponent,
    modifier: Modifier = Modifier,
) {
    val selectedActivityTypeId by component.selectedTypeId.collectAsState()
    Surface(
        modifier = modifier
            .fillMaxSize(),
        color = MaterialTheme.colors.background
    )
    {
        Column(modifier = Modifier.fillMaxSize()) {

            BoredActivitiesTypesRow(
                types = component.types,
                selectedType = selectedActivityTypeId
            )
            BoredActivityDescription()
        }
    }
}

@Composable
private fun BoredActivitiesTypesRow(
    types: List<BoredActivityType>,
    modifier: Modifier = Modifier,
    selectedType: BoredActivityTypeValue
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.colors.background,
        elevation = 4.dp
    ) {
        Column {
            Text(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 12.dp),
                text = stringResource(id = R.string.bored_activities),
                style = MaterialTheme.typography.h6
            )

            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp, vertical = 12.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                types.forEach {
                    BoredActivityTypeItem(
                        type = it,
                        isSelected = it.typeValue == selectedType
                    )
                }
            }
        }
    }
}


@Preview
@Composable
private fun BoredActivityDescription(
    // activtyName: String,
    //activityType: String,
    //participates: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.colors.background,
        elevation = 4.dp,
    ) {
        Column {
            Text(
                modifier = modifier.padding(start = 16.dp, top = 16.dp, bottom = 10.dp),
                //text = stringResource(id = R.string.bored_activity_name) + activtyName
                text = stringResource(id = R.string.bored_activity_name) + "Футбол"
            )
            Text(
                modifier = modifier.padding(start = 16.dp, bottom = 10.dp),
                //text = stringResource(id = R.string.bored_activity_type) + activityType
                text = stringResource(id = R.string.bored_activity_type) + ""
            )
            Text(
                modifier = modifier.padding(start = 16.dp, bottom = 10.dp),
                //text = stringResource(id = R.string.bored_activity_participants_amount) +participates
                text = stringResource(id = R.string.bored_activity_participants_amount) + "3"
            )

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(),
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            ) {
                Text(text = stringResource(id = R.string.get_new_activity))
            }

        }
    }
}

