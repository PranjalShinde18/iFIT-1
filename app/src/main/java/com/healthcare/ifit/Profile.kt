package com.healthcare.ifit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ProfileScreen(
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
                        modifier = Modifier.size(40.dp)
                            .clickable { onHomeSc?.invoke() }
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.workout),
                        contentDescription = "Workout",
                        tint = Color.White,
                        modifier = Modifier.size(40.dp)
                            .clickable { onPHSc?.invoke() }
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.medition),
                        contentDescription = "Meditation",
                        tint = Color.White,
                        modifier = Modifier.size(40.dp)
                            .clickable { onMHSc?.invoke() }
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Profile",
                        tint = Color.White,
                        modifier = Modifier.size(40.dp)
                            .clickable { onPrSc?.invoke() }
                    )
                }
            }
        }
    ) {
        it

        Profile(
            onHomeSc = onHomeSc,
            onPHSc = onPHSc,
            onMHSc = onMHSc,
            onPrSc = onPrSc,
        )
    }
}





@Composable
fun Profile(
    onHomeSc: () -> Unit,
    onPHSc: () -> Unit,
    onMHSc: () -> Unit,
    onPrSc: () -> Unit
) {
    // Define state variables to hold profile information
    val name = remember { mutableStateOf("Pranjal") }
    val age = remember { mutableStateOf(20) }
    val gender = remember { mutableStateOf("Male") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Profile picture
            Image(
                painter = painterResource(id = R.drawable.p),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color(0xFF2a2a2a))
                    .padding(16.dp),
                contentScale = ContentScale.Crop
            )

            // Profile information
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = name.value,
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Age: ${age.value}",
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Gender: ${gender.value}",
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Edit button
            Button(
                onClick = { /* TODO */ },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 8.dp)
                    .width(320.dp)
                    .aspectRatio(5f),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary
                )

            )

            {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "Edit Profile"
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Edit Profile",
                    style = MaterialTheme.typography.button
                )
            }

            Button(
                onClick = { /* TODO */ },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 8.dp)
                    .width(320.dp)
                    .aspectRatio(5f),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary
                )

            )

            {
                Icon(
                    imageVector = Icons.Filled.Call,
                    contentDescription = "Edit Profile"
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "About us",
                    style = MaterialTheme.typography.button
                )
            }

            Button(
                onClick = { /* TODO */ },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 8.dp)
                    .width(320.dp)
                    .aspectRatio(5f),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary
                )

            )

            {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Edit Profile"
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Premium",
                    style = MaterialTheme.typography.button
                )
            }

            Button(
                onClick = { /* TODO */ },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 8.dp)
                    .width(320.dp)
                    .aspectRatio(5f),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary
                )

            )

            {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "Reminder"
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Reminder",
                    style = MaterialTheme.typography.button
                )
            }

            Button(
                onClick = { /* TODO */ },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 8.dp)
                    .width(320.dp)
                    .aspectRatio(5f),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary
                )

            )

            {
                Icon(
                    imageVector = Icons.Filled.ThumbUp,
                    contentDescription = "Edit Profile"
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "help & support",
                    style = MaterialTheme.typography.button
                )


            }

            Button(
                onClick = { /* TODO */ },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 8.dp)
                    .width(320.dp)
                    .aspectRatio(5f),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary
                )

            )

            {
                Row(horizontalArrangement = Arrangement.Center) {


                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "Edit Profile"
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Sign out",
                        style = MaterialTheme.typography.button
                    )


                }
            }

        }
    }
}