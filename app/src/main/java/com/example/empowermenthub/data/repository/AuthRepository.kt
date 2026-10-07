package com.example.empowermenthub.data.repository

import com.google.firebase.auth.FirebaseAuth

class AuthRepository {

    private val auth = FirebaseAuth.getInstance()

    fun registerUser(
        email: String,
        password: String,
        onResult: (Boolean, String) -> Unit
    ) {

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {

                if (it.isSuccessful)
                    onResult(true, "Success")
                else
                    onResult(false, it.exception?.message ?: "Error")

            }
    }

    fun loginUser(
        email: String,
        password: String,
        onResult: (Boolean, String) -> Unit
    ) {

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {

                if (it.isSuccessful)
                    onResult(true, "Success")
                else
                    onResult(false, it.exception?.message ?: "Error")

            }
    }

    fun getCurrentUser() = auth.currentUser
}