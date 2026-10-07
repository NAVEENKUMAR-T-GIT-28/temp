package com.example.empowermenthub.data.repository

import com.example.empowermenthub.data.model.User
import com.google.firebase.firestore.FirebaseFirestore

class UserRepository {

    private val db = FirebaseFirestore.getInstance()

    fun saveUser(user: User) {

        db.collection("users")
            .document(user.uid)
            .set(user)
    }

    fun getUser(
        uid: String,
        onResult: (User?) -> Unit
    ) {

        db.collection("users")
            .document(uid)
            .get()
            .addOnSuccessListener {

                onResult(it.toObject(User::class.java))

            }
    }
}