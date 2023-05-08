
package com.healthcare.ifit.mentalhealth.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.healthcare.ifit.R
import com.healthcare.ifit.ui.theme.IFITTheme



@Composable
fun MentalHealthScreen (
    onMeditation: () -> Unit,
    onSleep: () -> Unit,
) {
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(state),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        Text(
            text = "Good Afternoon",
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.W500,
            textAlign = TextAlign.Start
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, top = 16.dp, bottom = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
            ) {
                Text(
                    text = "How was your day?",
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.W400,
                    textAlign = TextAlign.Start
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    Icon(
                        painter = painterResource(id = R.drawable.happy),
                        contentDescription = "happy",
                        tint = Color.Yellow,
                        modifier = Modifier.size(48.dp)
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.satisfied),
                        contentDescription = "satisfied",
                        tint = Color.Yellow,
                        modifier = Modifier.size(48.dp)
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.neutral),
                        contentDescription = "neutral",
                        tint = Color.Yellow,
                        modifier = Modifier.size(48.dp)
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.dissatisfied),
                        contentDescription = "dissatisfied",
                        tint = Color.Yellow,
                        modifier = Modifier.size(48.dp)
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.sad),
                        contentDescription = "sad",
                        tint = Color.Yellow,
                        modifier = Modifier.size(48.dp)
                    )

                }
            }
            
        }

        Card(
            modifier = Modifier
                .height(104.dp)
                .aspectRatio(3f, false)
                .align(Alignment.Start)
                .clickable { onMeditation?.invoke() }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Card(
                    backgroundColor = MaterialTheme.colors.primary,
                 //   modifier = Modifier.size(120.dp)
                ) {
                    Icon(
                        painterResource(id = R.drawable.medition) ,
                        contentDescription = "meditation",
                    )
                }
                Text(text = "Meditation", style = MaterialTheme.typography.h4)
            }
        }

        Card(
            modifier = Modifier
                .height(104.dp)
                .aspectRatio(3f, true)
                .align(Alignment.Start)
                .clickable { onSleep?.invoke() }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Card(
                    backgroundColor = MaterialTheme.colors.secondary
                ) {
                    Icon(
                        painterResource(id = R.drawable.sleeping),
                        contentDescription = "sleep",
                    )
                }
                Text(text = "Sleep", style = MaterialTheme.typography.h4)
            }
        }

        Card() {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Today's Quote :",
                    style = MaterialTheme.typography.h4
                )
                Text(
                    text = stringResource(R.string.quote1),
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Justify
                )
            }
        }

        Text(
            text = "Blogs",
            style = MaterialTheme.typography.h4,
            color = Color.White
        )

        MyCard(
            imageResource = R.drawable.on,
            cardTitle = "WORK OUT ROUTINE",
            cardContent = "There are may work out routine but we suggest you to have a PUSH PULL & LEGS as this is the most optimal and scientific way of training.\n" +
                    "Lets say you do a push day(shoulders, chest and triceps) on monday then you would be training legs(Quads,hamstring and calves) on tuesday and pull(Back,Traps,Lats and biceps) on wednesday the  this continues.\n" +
                    "Make sure to take rest when ever needed you can have a rest day after every cycle of p l p if you need.\n"

        )

        MyCard(
            imageResource = R.drawable.tw,
            cardTitle = "How to maximize performance",
            cardContent = " There are five main points that has to be on point to maximize performance in any physical aspect that maybe strength,cardio or any other feild.\n" +
                    "1) Sleep this is the most important as it is the time where your body heals and grows , it is the time when muscle is built. \n" +
                    "2) Having enough protein as protein is the building block of muscles. we recommend taking 0.8g to 1.8g of protein per kg of lean body mass.\n" +
                    "3) Dink enough water to stay hydrated as being dehydrated can lead to negative effect on your body thus not leading to optimal performance\n" +
                    "4) Using the principle of progressive overload this principle states that we have to constantly increase the difficulty of our training so as to improve performance, Example - If you are running 1km daily then soon running 1 km won't be hard for your body as your body would have adapted to the stimuli thus you will have increase the running distance or decrease the amount of time it takes for you to complete 1km.\n" +
                    "5) Principle of specificity this states that to improve in a particular activity the individual has to perform that activity using progressive overload and has to be consistent \n" +
                    "THERE YOU GO NOW YOU ARE READY TO MOVE. ALL THE BEST."
        )

        MyCard(
            imageResource = R.drawable.th,
            cardTitle = "Arms",
            cardContent = "For a well rounded routine,it is best to perform a variety of movements at each joint\n" +
                    "\n" +
                    "If you want to taring your arms,you can't just your arms.To progress with your arm exercises you also need to build strength in other parts of the body otherwise some exercise become too tough.\n"
        )

        MyCard(
            imageResource = R.drawable.fi,
            cardTitle = "Cardio",
            cardContent = "Any type of exercise that gest your heart rate up.\n" +
                    "\n" +
                    "A stronger cardio-vascular system means more capillaries deliverying more oxygen to celss in your muscels.This enables your celss to burn more fat during both exercise and inactivity.Cardio exercise uses large muscel movemenr over a sustained period of time keeping your heart rate to at least 50% of its maximum level\n "
        )





        
    }
}


@Composable
fun MyCard(imageResource: Int, cardTitle: String, cardContent: String) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        backgroundColor = MaterialTheme.colors.surface

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                //.padding(4.dp)
                .background(color = MaterialTheme.colors.surface)
        ) {
            Text(
                text = cardTitle,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(bottom = 16.dp, top = 16.dp),
                textAlign = TextAlign.Justify
            )
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = "Meditation",
                modifier = Modifier
                    .size(400.dp)
                    .padding(bottom = 1.dp)
            )
            Text(
                text = cardContent,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}


@Preview(showBackground = false)
@Composable
fun MentalScreenPreview() {
    IFITTheme() {
        MentalHealthScreen(
            onMeditation = { /*TODO*/ },
            onSleep = { /*TODO*/ },
        )

    }
}


