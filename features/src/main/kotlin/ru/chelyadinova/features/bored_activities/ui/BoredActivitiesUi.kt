package ru.chelyadinova.features.bored_activities.ui

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.chelyadinova.features.bored_activities.domain.BoredActivityType
import ru.mobileup.template.features.R

@Preview
@Composable
fun BoredActivitiesUi(
    modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    )
    {
        BoredActivitiesTypesRow(
            types = listOf(
                BoredActivityType.BUSYWORK,
                BoredActivityType.CHARITY,
                BoredActivityType.COOKING
            )
        )
        BoredActivityDescription()
    }
}

@Composable
private fun BoredActivitiesTypesRow(
    types: List<BoredActivityType>,
    modifier: Modifier = Modifier
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
        }
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .fillMaxWidth()
        ) {
            types.forEach {
                BoredActivityType(
                    it.type
                )
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
        elevation = 4.dp
    ) {
        Column(modifier = modifier.fillMaxSize()) {
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

            Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(), ) {
                Text(text = stringResource(id = R.string.get_new_activity))
            }

        }
    }
}

