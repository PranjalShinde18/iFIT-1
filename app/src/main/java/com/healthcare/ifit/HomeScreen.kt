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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.healthcare.ifit.ui.theme.Cyan700
import com.healthcare.ifit.ui.theme.Green50
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
        topBar = {
            TopAppBar(
                modifier = Modifier.height(160.dp),
                backgroundColor = Cyan700,
                contentColor = Color.White,
                elevation = 0.dp
            ) {
                Column(
                    modifier = Modifier.padding(start = 24.dp)
                ) {
                    Text(
                        text = "Hello",
                        style = MaterialTheme.typography.h2,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Pranjal Shinde",
                        style = MaterialTheme.typography.h5,
                    )
                }
            }
        },
        bottomBar = {
            Card() {
                Card(
                    modifier = Modifier
                        //  .wrapContentSize(Alignment.BottomEnd)
                        .padding(20.dp)
                        .height(64.dp),
                    backgroundColor = Color.Black,
                    shape = RoundedCornerShape(16.dp),
                    elevation = 8.dp
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.spacedBy(
                            96.dp,
                            Alignment.CenterHorizontally
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Home,
                            contentDescription = "Home",
                            tint = Green50,
                            modifier = Modifier.size(36.dp)
                        )

                        Icon(
                            painter = painterResource(id = R.drawable.outline_psychology_24),
                            contentDescription = "Home",
                            tint = Green50,
                            modifier = Modifier.size(36.dp)
                        )

                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "Home",
                            tint = Green50,
                            modifier = Modifier.size(36.dp)
                        )
                    }
                }
            }
        }

    ) {
        Surface(
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
            elevation = 0.dp,
            modifier = Modifier.padding(it)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 40.dp, start = 24.dp, end = 24.dp),
                verticalArrangement = Arrangement.spacedBy(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(200.dp)
                        .aspectRatio(3f, false)
                        .clickable(onClick = onBMIcal)
                        .padding(top = 10.dp),
//                    backgroundColor = Color.DarkGray,
//                    contentColor = Color.White,
                    shape = RoundedCornerShape(16.dp),
                    elevation = 16.dp
                ) {
                    Text(
                        text = "BMI",
                        style = MaterialTheme.typography.h3,
                        textAlign = TextAlign.Center
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .weight(1f, true)
                            .clickable(onClick = onMedicine)
                            .aspectRatio(1f,false),
                        elevation = 16.dp,
                        shape = RoundedCornerShape(16.dp),

                        ) {
                        Text(
                            text = "Medicine \n Reminder",
                            style = MaterialTheme.typography.h4,
                            textAlign = TextAlign.Center
                        )
                    }
                    Card(
                        modifier = Modifier
                            .weight(1f, true)
                            .aspectRatio(1f,false),
                        elevation = 16.dp,
                        shape = RoundedCornerShape(16.dp)
                        ) {
                        Text(
                            text = "Sleep \n Tracker",
                            style = MaterialTheme.typography.h4,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(2f, false)
                        .clickable(onClick = onWater),
                    elevation = 16.dp,
                    shape = RoundedCornerShape(16.dp)

                ) {
                    Text(
                        text = "Water Intake",
                        style = MaterialTheme.typography.h4,
                    )
                }
            }
        }
    }
}

@Composable
fun WaterTrackerCard() {
    Card() {
        
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