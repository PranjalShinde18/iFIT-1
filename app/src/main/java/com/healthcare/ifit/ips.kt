package com.healthcare.ifit

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


@Composable
fun InputScreenn(
    onDataInserted: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )
        OutlinedTextField(
            value = height,
            onValueChange = { height = it },
            label = { Text("Height") }
        )
        OutlinedTextField(
            value = weight,
            onValueChange = { weight = it },
            label = { Text("Weight") }
        )
        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Age") }
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
