package com.healthcare.ifit
//
//import android.content.ContentValues
//import android.util.Log
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.firestore.FirebaseFirestore
//
//fun fetchingData ():String {
//    val currentUser = FirebaseAuth.getInstance().currentUser
//    val currentUserId = currentUser?.uid
//
//    println(currentUserId)
//
//    if (currentUserId != null) {
//        FirebaseFirestore.getInstance().collection("users")
//            .document(currentUserId)
//            .get()
//            .addOnSuccessListener { document ->
//                if (document != null && document.exists()) {
//                    val uname = document.getString("name")
//                    val age = document.getString("age")
//                    val gender = document.getString("gender")
//                    val height = document.getString("height")
//                    val weight = document.getString("weight")
//                    Log.d(ContentValues.TAG, "$uname $age $gender $height $weight")
//
//
//                } else {
//                    Log.d(ContentValues.TAG, "No such document")
//                }
//            }
//            .addOnFailureListener { exception ->
//                Log.d(ContentValues.TAG, "Error getting document: ", exception)
//            }
//    } else {
//        Log.d(ContentValues.TAG, "No current user")
//    }
//    return "xc"
//}
//
