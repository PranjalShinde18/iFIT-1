package com.healthcare.ifit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.healthcare.ifit.ui.theme.IFITTheme


@Composable
fun HomeScreen(
    userData: UserData?,
    onSignOut: () -> Unit,
    onBMIcal: ()-> Unit,
    onWater: ()-> Unit,
    onMedicine: () -> Unit
) {
    Scaffold(
        bottomBar = {}
    ) {
        it
        HomeScreenUi()
    }

}

@Composable
fun HomeScreenUi() {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
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
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            Card() {
                Text(text = "Water Intake")
            }

            Card() {
                Text(text = "Medicine Tracker")
            }

        }

        Row() {

            Card() {
                Text(text = "Height")
            }

            Card() {
                Text(text = "Weight")
            }
        }

        Card() {
            Text(text = "Bmi Calculator")
        }

        Card() {
            Text(text = "Your Mood")
        }
    }


}



@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    IFITTheme {
        HomeScreen(
            userData = null,
            onSignOut = { /*TODO*/ },
            onBMIcal = { /*TODO*/ },
            onWater = { /*TODO*/ }) {

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