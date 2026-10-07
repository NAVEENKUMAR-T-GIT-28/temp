package com.example.empowermenthub.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun EmployeeDetailsScreen(navController: NavController) {

    val db = FirebaseFirestore.getInstance()

    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var resume by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text("Employee Details", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Phone") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = resume,
            onValueChange = { resume = it },
            label = { Text("Resume Link") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

            val employee = hashMapOf(
                "name" to name,
                "phone" to phone,
                "resume" to resume
            )

            db.collection("employees")
                .add(employee)
                .addOnSuccessListener {

                    // Navigate to dashboard AFTER saving
                    navController.navigate("employeeDashboard")

                }

        }) {
            Text("Save Details")
        }

    }
}