package com.healthcare.ifit.featuresUi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Animatable
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.healthcare.ifit.R
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
        mutableStateOf(4)
    }

    val imageResource = R.drawable.zero

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

 //       AnimatedCircularProgressIndicator(progress = result / 8.toFloat())


        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { result = if (result == 0) 0 else --result },
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                border = BorderStroke(0.dp, Color.Transparent),

            ) {
                Text(
                    text = stringResource(R.string.red),
                    fontSize = 24.sp
                )
            }
            Spacer(modifier = Modifier.width(32.dp))
            Box(modifier = Modifier,
            contentAlignment = Alignment.Center){
                Image(
                    modifier = Modifier.size(120.dp),
                    painter = painterResource(imageResource),
                    contentDescription = result.toString()
                )
                AnimatedCircularProgressIndicator(progress = result / 8.toFloat())
            }
//            Image(
//                modifier = Modifier.size(96.dp),
//                painter = painterResource(imageResource),
//                contentDescription = result.toString()
//            )
            Spacer(modifier = Modifier.width(32.dp))
            Button(
                onClick = { result = if (result == 8) 0 else ++result },
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                border = BorderStroke(0.dp, Color.Transparent)

            ) {
                Text(
                    text = stringResource(R.string.inc),
                    fontSize = 24.sp
                    )
            }
        }

    }
}

@Composable
fun AnimatedCircularProgressIndicator(
    progress: Float,
    modifier: Modifier = Modifier,
    strokeWidth: Dp = 20.dp,
    animationDuration: Int = 1000
) {
    val animatedProgress = remember { androidx.compose.animation.core.Animatable(0f) }

    LaunchedEffect(progress) {
        animatedProgress.animateTo(
            targetValue = progress,
            animationSpec = tween(durationMillis = animationDuration)
        )
    }

    CircularProgressIndicator(
        modifier = modifier
            .size(160.dp),
        progress = animatedProgress.value,
        strokeWidth = strokeWidth
    )
}