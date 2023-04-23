package com.healthcare.ifit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.healthcare.ifit.ui.theme.IFITTheme

class Water : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IFITTheme {
                WaterTracker()
            }
        }
    }
}
@Preview
@Composable
fun WaterTracker(){
    WaterTrackerScreen(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}

@Composable
fun WaterTrackerScreen (modifier: Modifier = Modifier) {
    var result by remember {
        mutableStateOf(0)
    }
    val imageResource = when (result) {
        0 -> R.drawable.zero
        1 -> R.drawable.one
        2 -> R.drawable.two
        3 -> R.drawable.three
        4 -> R.drawable.four
        5 -> R.drawable.five
        6 -> R.drawable.six
        else -> R.drawable.seven
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { result = if (result == 0) 0 else --result },
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                border = BorderStroke(0.dp, Color.Transparent),

            ) {
                Text(text = stringResource(R.string.red))
            }
            Spacer(modifier = Modifier.width(32.dp))
            Image(
                modifier = Modifier.size(96.dp),
                painter = painterResource(imageResource),
                contentDescription = result.toString()
            )
            Spacer(modifier = Modifier.width(32.dp))
            Button(
                onClick = { result = ++result },
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                border = BorderStroke(0.dp, Color.Transparent)

            ) {
                Text(text = stringResource(R.string.inc))
            }
        }

    }
}