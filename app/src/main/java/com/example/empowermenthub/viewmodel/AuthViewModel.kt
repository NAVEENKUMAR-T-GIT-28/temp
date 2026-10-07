package com.example.empowermenthub.viewmodel

import androidx.lifecycle.ViewModel
import com.example.empowermenthub.data.repository.AuthRepository

class AuthViewModel : ViewModel() {

    private val repo = AuthRepository()

    fun loginUser(
        email: String,
        password: String,
        onResult: (Boolean, String) -> Unit
    ) {
        repo.loginUser(email, password, onResult)
    }

    fun registerUser(
        email: String,
        password: String,
        onResult: (Boolean, String) -> Unit
    ) {
        repo.registerUser(email, password, onResult)
    }
}