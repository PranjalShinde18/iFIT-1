package com.healthcare.ifit

import android.widget.Toast
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
import com.google.firebase.ktx.Firebase
import com.healthcare.ifit.realtimedb.User

//@Preview(showBackground = true)
@Composable
fun InputScreen(
    onNextClick : ()-> Unit
) {

    val context = LocalContext.current
    val database = Firebase.database
    val myRef = database.getReference("User")



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
            onClick = {

                      if (userheight.isNotEmpty() && userweight.isNotEmpty() && userage.isNotEmpty() && usergender.isNotEmpty()) {

                            val userinfo = User(userheight,userweight,userage,usergender)

                          myRef.child(userheight).setValue(userinfo).addOnSuccessListener {
                              userage = ""
                              usergender = ""
                              userheight = ""
                              userweight = ""
                              Toast.makeText(context,"Record inserted",Toast.LENGTH_LONG).show()


                              onNextClick()


                          }
                              .addOnFailureListener {
                                  Toast.makeText(context,"Record not inserted",Toast.LENGTH_LONG).show()
                              }


                      } else {
                          Toast.makeText(context,"Pls insert values" ,Toast.LENGTH_LONG).show()
                      }


            },

            modifier = Modifier
                .width(144.dp)
                .aspectRatio(3f, false)
        ) {


            Text(text = "Next")

        }
    }

}