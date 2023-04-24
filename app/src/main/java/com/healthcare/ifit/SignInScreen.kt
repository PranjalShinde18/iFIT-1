package com.healthcare.ifit

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.google.firebase.ktx.Firebase
import com.healthcare.ifit.realtimedb.User
import com.healthcare.ifit.uiState.SignInState

@Composable
fun SignInScreen(
    state: SignInState,
    onSignInClick: () -> Unit
) {

    val database = Firebase.database
    val myRef = database.getReference("User")


    var username by remember { mutableStateOf("") }
    var userpassword by remember { mutableStateOf("") }


    val context = LocalContext.current

    LaunchedEffect(key1 = state.signInError) {
        state.signInError?.let { error ->
            Toast.makeText(
                context,
                error,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 80.dp)
            .wrapContentSize(Alignment.BottomCenter),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {


        Image(
            painter = painterResource(id = R.drawable.ic_android_black_24dp),
            contentDescription = null,
            modifier = Modifier
                .size(144.dp)
                .weight(1f, fill = true)
                .wrapContentSize(Alignment.Center)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = username,
                onValueChange = {username = it},
                label = {
                    Text(text = "Name")
                },

                )
            Spacer(modifier = Modifier.height(0.dp))
            OutlinedTextField(
                value = userpassword,
                onValueChange = {userpassword = it},
                label = {
                    Text(text = "Password")
                },
            )
            Spacer(modifier = Modifier.height(16.dp))

        }

        Button(
            onClick = {
                if (username.isNotEmpty() && userpassword.isNotEmpty()) {

                    val userinfo = User(username,userpassword)

                    myRef.child(username).setValue(userinfo).addOnSuccessListener {
                        username = ""
                        userpassword = ""

                        Toast.makeText(context,"Record inserted",Toast.LENGTH_LONG).show()

                        onSignInClick()

                    }
                        .addOnFailureListener {
                            Toast.makeText(context,"Record not inserted",Toast.LENGTH_LONG).show()
                        }


                } else {
                    Toast.makeText(context,"Pls insert values" ,Toast.LENGTH_LONG).show()
                }
            }

        ) {
            Text(text = "SignIn")
        }
    }
}
