package com.healthcare.ifit.model

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.healthcare.ifit.User
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


class DataViewModel: ViewModel() {

   val state = mutableStateOf(User())


    init {
        getData()
    }

    private fun getData(){
        viewModelScope.launch {
            state.value = getDataFromFireStore()
        }
    }

}


suspend fun getDataFromFireStore() : User{

    val db = FirebaseFirestore.getInstance()

    val currentUser = FirebaseAuth.getInstance().currentUser
    val currentUserId = currentUser?.uid

    var users = User()

    try {
        if (currentUserId != null) {
            val documentSnapshot = db
                .collection("users")
                .document(currentUserId)
                .get()
                .await()

            val result = documentSnapshot.toObject(User::class.java)
            if (result != null) {
                users = result
            }
        }
    } catch (e: FirebaseFirestoreException) {
        Log.d("error","getDataFromFireStore: $e")
    }

    return users
}