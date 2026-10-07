package com.example.empowermenthub.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun EmployerDetailsScreen(navController: NavController) {

    val db = FirebaseFirestore.getInstance()

    var company by remember { mutableStateOf("") }
    var gst by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text("Employer Details", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = company,
            onValueChange = { company = it },
            label = { Text("Company Name") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = gst,
            onValueChange = { gst = it },
            label = { Text("GST Number") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = address,
            onValueChange = { address = it },
            label = { Text("Address") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

            val employer = hashMapOf(
                "company" to company,
                "gst" to gst,
                "address" to address
            )

            db.collection("employers")
                .add(employer)
                .addOnSuccessListener {

                    navController.navigate("employerDashboard")

                }

        }) {
            Text("Save Details")
        }

    }
}