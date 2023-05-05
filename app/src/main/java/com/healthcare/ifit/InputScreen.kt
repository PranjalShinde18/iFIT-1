package com.healthcare.ifit

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

//@Preview(showBackground = true)
@Composable
fun InputScreen(
    onNextClick : ()-> Unit
) {

    val context = LocalContext.current
    val database = Firebase.firestore


    var username by remember { mutableStateOf("") }
    var userheight by remember { mutableStateOf("") }
    var userweight by remember { mutableStateOf("") }
    var userage by remember { mutableStateOf("") }
    var usergender by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.BottomCenter)
            .padding(bottom = 80.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ifit),
            contentDescription = null,
            modifier = Modifier
                .size(144.dp)
                .weight(1f, fill = true)
                .wrapContentSize(Alignment.Center)
        )

        OutlinedTextField(
            value = username,
            onValueChange = {username = it},
            label = {
                Text(text = "Name")
            }
        )

        OutlinedTextField(
            value = userheight,
            onValueChange = {userheight = it},
            label = {
                Text(text = "Height")
            }
        )

        OutlinedTextField(
            value = userweight,
            onValueChange = {userweight = it},
            label = {
                Text(text = "Weight")
            }
        )

        OutlinedTextField(
            value = userage,
            onValueChange = {userage = it},
            label = {
                Text(text = "Age")
            }
        )

        OutlinedTextField(
            value = usergender,
            onValueChange = {usergender = it},
            label = {
                Text(text = "Gender")
            }
        )

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = onNextClick,

            modifier = Modifier
                .width(144.dp)
                .aspectRatio(3f, false)
        ) {


            Text(text = "Next")

        }
    }
}