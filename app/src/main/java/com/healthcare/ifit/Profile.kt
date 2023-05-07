package com.healthcare.ifit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.healthcare.ifit.model.DataViewModel


@Composable
fun ProfileScreen(
    onHomeSc: () -> Unit,
    onPHSc: () -> Unit,
    onMHSc: () -> Unit,
    onPrSc: () -> Unit,
    onSignOut: () -> Unit,
    updateProfile: () -> Unit,
    userData: UserData?,

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
            onSignOut = onSignOut,
            updateProfile = updateProfile,
            userData = userData
        )
    }
}







@Composable
fun Profile(
    onHomeSc: () -> Unit,
    onPHSc: () -> Unit,
    onMHSc: () -> Unit,
    onPrSc: () -> Unit,
    onSignOut: () -> Unit,
    updateProfile: () -> Unit,
    userData: UserData?,

    dataViewModel: DataViewModel = viewModel()

) {

    val getData = dataViewModel.state.value


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {


            Spacer(modifier = Modifier.height(54.dp))

            // Profile picture
            if (userData?.profilePictureUrl != null) {
                AsyncImage(
                    model = userData.profilePictureUrl,
                    contentDescription = "Profile picture",
                    modifier = Modifier
                        .size(180.dp)
                        .align(Alignment.CenterHorizontally)
                        .background(Color(0xFF2a2a2a))
                        .padding(16.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            // Profile information
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = getData.name,
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = getData.age,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = getData.gender,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Edit button
            Button(
                onClick = updateProfile,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 8.dp)
                    .width(320.dp)
                    .aspectRatio(5f),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary
                )

            ) {
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
                    imageVector = Icons.Filled.ThumbUp,
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "About Us",
                    style = MaterialTheme.typography.button
                )


            }

            Button(
                onClick = onSignOut,
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