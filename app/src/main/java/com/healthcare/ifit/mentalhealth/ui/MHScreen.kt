
package com.healthcare.ifit.MentalHealth.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.healthcare.ifit.R

@Composable

fun MentalScreen(
    onMeditation: () -> Unit,
    onSleep: () -> Unit,
) {

    Column(
        modifier = Modifier
            .fillMaxSize(),

    ) {

        Text("Welcome !",
            modifier = Modifier.padding(25.dp),
            fontSize = 40.sp
            )

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.meditation),
                contentDescription = null,
                modifier = Modifier
                    .size(300.dp, 64.dp)
                    .clickable {onMeditation?.invoke()}
                    .clip(RoundedCornerShape(8.dp))

            )

            Text(text = "Meditation",
                fontWeight = FontWeight.SemiBold,
                fontSize = 32.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 65.dp)
                )
        }


        Spacer(modifier = Modifier.height(15.dp))


        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.sleep),
                contentDescription = null,
                modifier = Modifier
                    .size(300.dp, 64.dp)
                    .clickable {onSleep?.invoke()}
                    .clip(RoundedCornerShape(8.dp))
            )

            Text(text = "Sleep",
                fontWeight = FontWeight.SemiBold,
                fontSize = 32.sp,
                color = Color.White
            )
        }

    }
}
