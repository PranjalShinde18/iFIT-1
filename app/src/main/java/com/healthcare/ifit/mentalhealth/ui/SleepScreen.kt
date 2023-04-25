package com.healthcare.ifit.mentalhealth.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.healthcare.ifit.R
import com.healthcare.ifit.ui.theme.IFITTheme


@Preview
@Composable
fun DailyMeditationScreenPreview(){
    IFITTheme {
        DailyMeditationScreenPreview()
    }
}

@Composable
fun DailyMeditationScreen() {
    val quotes = listOf(
        "When I go to sleep at night \n" +
                "Bathed In starts and palest light \n" +
                "I know an angel guards my room, \n" +
                "You might know him as the moon. \n" +
                "Without fail, as the sun does set \n" +
                "My dreams and I are gentaly met \n" +
                "To be Looked over all the way \n" +
                "Until we meet each bright new day. \n"
    )

    val currentQuote = remember { mutableStateOf("") }
    currentQuote.value = remember { quotes.random() }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Sleep",
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 8.dp, start = 4.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.night),
                contentDescription = "Meditation",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(200.dp)
                    .padding(bottom = 16.dp)
                    .clip(RoundedCornerShape(20)),
                contentScale = ContentScale.Crop

            )
            Text(
                text = currentQuote.value,
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Choose a duration",
                        style = MaterialTheme.typography.h5,

                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(
                            )
                        ) {
                            Text(
                                text = "15 min",
                            )
                        }
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(
                            )
                        ) {
                            Text(
                                text = "30 min",
                            )
                        }
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(
                            )
                        ) {
                            Text(
                                text = "45 min",
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                buildAnnotatedString {
                    withStyle(
                        style = ParagraphStyle(
                            textIndent = TextIndent(firstLine = 40.sp)
                        )
                    ) {
                        append("• Sleep is as essential as air, water and food \n")
                        append("• It is sleep when your body heals and grows\n")
                        append("• Try to sleep around 7 to 9 hours\n")
                        append("• Sleep is the best medicine against ageing\n")
                    }
                },
                style = MaterialTheme.typography.body1,
            )
        }
    }
}