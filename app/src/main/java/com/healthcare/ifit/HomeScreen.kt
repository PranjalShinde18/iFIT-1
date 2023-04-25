package com.healthcare.ifit

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
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.healthcare.ifit.ui.theme.IFITTheme

@Composable
fun HomeScreen(

    onSignOut: () -> Unit,
    onBMIcal: ()-> Unit,
    onWater: ()-> Unit,
    onMedicine: () -> Unit,
    onSleep: () -> Unit,

    onHomeSc: () -> Unit,
    onPHSc: () -> Unit,
    onMHSc: () -> Unit,
    onPrSc: () -> Unit

) {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(80.dp),
                backgroundColor = MaterialTheme.colors.background
            ) { ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.home),
                        contentDescription = "Home",
                        tint = Color.White,
                        modifier = Modifier
                            .size(40.dp)
                            .clickable { onHomeSc?.invoke() }
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.workout),
                        contentDescription = "Workout",
                        tint = Color.White,
                        modifier = Modifier
                            .size(40.dp)
                            .clickable { onPHSc?.invoke() }
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.medition),
                        contentDescription = "Meditation",
                        tint = Color.White,
                        modifier = Modifier
                            .size(40.dp)
                            .clickable { onMHSc?.invoke() }
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Profile",
                        tint = Color.White,
                        modifier = Modifier
                            .size(40.dp)
                            .clickable { onPrSc?.invoke() }
                    )
                }
            }
        }
    ) {
        it
        HomeScreenUi(
        onBMIcal=onBMIcal,
        onWater = onWater,
        onMedicine = onMedicine,
            onSleep = onSleep
        )
    }

}

@Composable
fun HomeScreenUi(
    onBMIcal: ()-> Unit,
    onWater: ()-> Unit,
    onMedicine: () -> Unit,
    onSleep: () -> Unit,

) {
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .verticalScroll(state),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, top = 0.dp, bottom = 16.dp),
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Hello",
                    style = MaterialTheme.typography.h1,
                    fontWeight = FontWeight.W400,
                    textAlign = TextAlign.Start
                )

                Text(
                    text = "Pranjal Shinde!!",
                    style = MaterialTheme.typography.h4
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp,),
         //       .weight(1.5f, true),
            horizontalArrangement = Arrangement.spacedBy(16.dp,Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    //.width(144.dp)
                    .aspectRatio(1.3f, false)
                    .weight(1f)
                    .clickable { onSleep?.invoke() },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(painterResource(id = R.drawable.sleeping), contentDescription = null,
                    modifier = Modifier.size(20.dp))
            }

            Card(
                modifier = Modifier
                    //.width(144.dp)
                    .aspectRatio(1.3f, false)
                    .weight(1f)
                    .clickable { onMedicine?.invoke() },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Text(text = "Medicine Tracker")
            }

        }



        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
        //        .weight(1.5f, true),
            horizontalArrangement = Arrangement.spacedBy(16.dp,Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Card(
                modifier = Modifier
                    //.width(144.dp)
                    .aspectRatio(1.3f, false)
                    .weight(1f),
                backgroundColor = MaterialTheme.colors.secondary
            ) {
                Text(text = "Height")
            }

            Card(
                modifier = Modifier
                    //.width(144.dp)
                    .aspectRatio(1.3f, false)
                    .weight(1f),
                backgroundColor = MaterialTheme.colors.secondary
            ) {
                Text(text = "Weight")
            }
        }

        Card(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth()
                .height(80.dp)
                .clickable { onBMIcal?.invoke() },
        //        .weight(1f, false),
            backgroundColor = MaterialTheme.colors.primary
        ) {
            Text(text = "Bmi Calculator")
        }

        Card(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth()
                .height(80.dp)
                .clickable { onWater?.invoke() },
        //        .weight(1f, false),
            backgroundColor = MaterialTheme.colors.secondary
        ) {
            Text(text = "Water Intake")
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    IFITTheme() {
        HomeScreen(
            onSignOut = { /*TODO*/ },
            onBMIcal = { /*TODO*/ },
            onWater = { /*TODO*/ },
            onMedicine = { /*TODO*/ },
            onSleep = { /*TODO*/ },
            onHomeSc = { /*TODO*/ },
            onPHSc = { /*TODO*/ },
            onMHSc = { /*TODO*/ }) {
            
        }
    }
}
