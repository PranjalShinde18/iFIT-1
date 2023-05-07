package com.healthcare.ifit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun JetLaggedHeader(modifier: Modifier = Modifier) {
    Box(
        modifier.height(150.dp)
    ) {
        Row(modifier = Modifier.windowInsetsPadding(insets = WindowInsets.systemBars)) {
            IconButton(
                onClick = { },
            ) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.not_implemented)
                )
            }

            Text(
                stringResource(R.string.jetlagged_app_heading),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                style = MaterialTheme.typography.h3,
                textAlign = TextAlign.Start
            )
        }
    }
}

@Preview
@Composable
fun JetLaggedSleepSummary(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                stringResource(R.string.average_time_in_bed_heading),
                style = MaterialTheme.typography.h6
            )
            Text(
                stringResource(R.string.placeholder_text_ave_time),
                style = MaterialTheme.typography.h3
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                stringResource(R.string.average_sleep_time_heading),
                style = MaterialTheme.typography.h6
            )
            Text(
                stringResource(R.string.placeholder_text_ave_time_2),
                style = MaterialTheme.typography.h3,
            )
        }
    }
    Spacer(modifier = Modifier.height(32.dp))
}
