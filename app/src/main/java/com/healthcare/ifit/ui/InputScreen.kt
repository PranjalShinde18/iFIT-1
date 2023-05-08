package com.healthcare.ifit.ui

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.healthcare.ifit.R
import com.healthcare.ifit.ui.theme.IFITTheme

@Preview
@Composable
fun PreviewInputScreen() {
    IFITTheme() {
        InputScreen {}
    }
}
@Composable
fun InputScreen(
    onDataInserted: () -> Unit
) {
    var name  by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ifit),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .wrapContentSize(Alignment.Center)
        )
   //     Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },

            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text,imeAction = ImeAction.Next),

            keyboardActions = KeyboardActions(
                onNext = {focusManager.moveFocus(FocusDirection.Down)}
            )

        )
        OutlinedTextField(
            value = height,
            onValueChange = { height = it },
            label = { Text("Height") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number,imeAction = ImeAction.Next),

            keyboardActions = KeyboardActions(
                onNext = {focusManager.moveFocus(FocusDirection.Down)}
            )
        )
        OutlinedTextField(
            value = weight,
            onValueChange = { weight = it },
            label = { Text("Weight") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number,imeAction = ImeAction.Next),

            keyboardActions = KeyboardActions(
                onNext = {focusManager.moveFocus(FocusDirection.Down)}
            )
        )
        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Age") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number,imeAction = ImeAction.Next),

            keyboardActions = KeyboardActions(
                onNext = {focusManager.moveFocus(FocusDirection.Down)}
            )
        )

        OutlinedTextField(
            value = gender,
            onValueChange = { gender = it },
            label = { Text("Gender") }
        )
        Button(
            onClick = { saveUserData(name, height, weight, age, gender, onDataInserted) },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Save")
        }
    }
}

private fun saveUserData(
    name: String,
    height: String,
    weight: String,
    age: String,
    gender: String,

    onDataInserted: () -> Unit
) {

    val uid = FirebaseAuth.getInstance().currentUser?.uid
    if (uid != null) {
        val db = Firebase.firestore
        val user = hashMapOf(
            "name" to name,
            "height" to height,
            "weight" to weight,
            "age" to age,
            "gender" to gender
        )
        db.collection("users")
            .document(uid)
            .set(user)
            .addOnSuccessListener {
                // Data saved successfully
                onDataInserted()
            }
            .addOnFailureListener { e ->
                // Error occurred while saving data
                Log.e(TAG, "Error writing document", e)
            }
    } else {
        // User is not authenticated
        Log.e(TAG, "User is not authenticated")
    }

}
