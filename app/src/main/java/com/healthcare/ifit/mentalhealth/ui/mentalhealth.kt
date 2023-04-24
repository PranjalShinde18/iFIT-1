package com.healthcare.ifit.mentalhealth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.healthcare.ifit.R


@Composable
fun MeditationScreenUi(
    on3min : () -> Unit,
    on5min : () -> Unit,
    on10min : () -> Unit,
) {
    val quotes = listOf(
        "When Meditation is mastered the mind is unwavering like the flame of a lamp in a wundless place          ~  Shree Krishna"
    )

    val currentQuote = remember { mutableStateOf("") }
    currentQuote.value = remember { quotes.random() }

    Surface(
        color = Color.Black,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Daily Meditation",
                style = MaterialTheme.typography.h4,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 8.dp, start = 4.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.meditationimage),
                contentDescription = "Meditation",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(240.dp)
                    .padding(bottom = 16.dp)
            )
            Text(
                text = currentQuote.value,
                color = Color.White,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Card(
                backgroundColor = Color.Black,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Choose Duration",
                        style = MaterialTheme.typography.h5,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(
                            onClick = on3min,
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.White
                            )
                        ) {
                            Text(
                                text = "3 min",
                                color = Color.Black
                            )
                        }
                        Button(
                            onClick = on5min,
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.White
                            )
                        ) {
                            Text(
                                text = "5 min",
                                color = Color.Black
                            )
                        }
                        Button(
                            onClick = on10min,
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.White
                            )
                        ) {
                            Text(
                                text = "10 min",
                                color = Color.Black
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
                        append("• Reduce stress\n",)
                        append("• Control anxiety\n")
                        append("• Lengthens attention span\n")
                        append("• Improves sleep\n")
                    }
                },
                style = MaterialTheme.typography.body1,
                color = Color.White
            )


        }
    }
}