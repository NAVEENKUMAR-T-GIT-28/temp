package com.example.empowermenthub.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun EmployeeFeedbackScreen() {

    val db = FirebaseFirestore.getInstance()

    var feedback by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text("Job Feedback")

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = feedback,
            onValueChange = { feedback = it },
            label = { Text("Write Feedback") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

            val data = hashMapOf(
                "feedback" to feedback
            )

            db.collection("feedback")
                .add(data)

        }) {
            Text("Submit Feedback")
        }

    }

}