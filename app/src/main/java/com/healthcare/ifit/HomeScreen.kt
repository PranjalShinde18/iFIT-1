package com.healthcare.ifit

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
<<<<<<< HEAD
import androidx.compose.material.Button
=======
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomAppBar
>>>>>>> 1cb72a058c866410f6a47b7e689c22bcc97fd234
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
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.healthcare.ifit.ui.theme.IFITTheme


@Composable
fun HomeScreen(
    userData: UserData?,
    onSignOut: () -> Unit,
    onBMIcal: ()-> Unit,
    onWater: ()-> Unit,
    onMedicine: () -> Unit,
    onMentalHealth: () -> Unit
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
                        modifier = Modifier.size(56.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.workout),
                        contentDescription = "Workout",
                        tint = Color.White,
                        modifier = Modifier.size(56.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.medition),
                        contentDescription = "Meditation",
                        tint = Color.White,
                        modifier = Modifier.size(56.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Profile",
                        tint = Color.White,
                        modifier = Modifier.size(56.dp)
                    )
                }
            }
        }
    ) {
        it
        HomeScreenUi()
    }

}

@Composable
fun HomeScreenUi() {
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
              //  .weight(3f, false)
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
                    .weight(1f),
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Text(text = "Sleep Traker")
            }

            Card(
                modifier = Modifier
                    //.width(144.dp)
                    .aspectRatio(1.3f, false)
                    .weight(1f),
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
                .height(80.dp),
        //        .weight(1f, false),
            backgroundColor = MaterialTheme.colors.primary
        ) {
            Text(text = "Bmi Calculator")
        }

        Card(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth()
                .height(80.dp),
        //        .weight(1f, false),
            backgroundColor = MaterialTheme.colors.secondary
        ) {
            Text(text = "Water Intake")
        }
    }


}



@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    IFITTheme {
        HomeScreen(
            userData = null,
            onSignOut = {},
            onBMIcal = {},
            onWater = {},
        onMedicine = {})

        {

        }
    }
}


//if (userData?.profilePictureUrl != null) {
//    AsyncImage(
//        model = userData.profilePictureUrl,
//        contentDescription = "Profile picture",
//        modifier = Modifier
//            .size(150.dp)
//            .clip(CircleShape),
//        contentScale = ContentScale.Crop
//    )
//    Spacer(modifier = Modifier.height(16.dp))
//}
//    if (userData?.profilePictureUrl != null) {
//        AsyncImage(
//            model = userData.profilePictureUrl,
//            contentDescription = "Profile picture",
//            modifier = Modifier
//                .size(150.dp)
//                .clip(CircleShape),
//            contentScale = ContentScale.Crop
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//    }
//    if (userData?.username != null) {
//        Text(
//            text = userData.username,
//            textAlign = TextAlign.Center,
//            fontSize = 36.sp,
//            fontWeight = FontWeight.SemiBold
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//    }
//    Button(onClick = onSignOut) {
//        Text(text = "Sign out")
//    }
//
//    Button(onClick = onBMIcal) {
//        Text(text = "BMI-Calculator")
//    }
//
//    Button(onClick = onWater) {
//        Text(text = "Water-Tracker")
//    }
//
//    Button(onClick = onMedicine) {
//        Text(text = "Medicine")
//    }
//}