package com.example.empowermenthub.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.empowermenthub.data.model.ApplicationModel
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun EmployerApplicationsScreen() {

    val db = FirebaseFirestore.getInstance()

    var applications by remember { mutableStateOf<List<ApplicationModel>>(emptyList()) }

    LaunchedEffect(true) {

        db.collection("applications")
            .get()
            .addOnSuccessListener { result ->

                val list = mutableListOf<ApplicationModel>()

                for (doc in result) {

                    val app = doc.toObject(ApplicationModel::class.java)
                    app.id = doc.id

                    list.add(app)
                }

                applications = list
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("Job Applications")

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn {

            items(applications) { app ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text("Employee: ${app.employeeName}")
                        Text("Status: ${app.status}")

                        Spacer(modifier = Modifier.height(10.dp))

                        Row {

                            Button(onClick = {

                                db.collection("applications")
                                    .document(app.id)
                                    .update("status", "accepted")

                            }) {
                                Text("Accept")
                            }

                            Spacer(modifier = Modifier.width(10.dp))

                            Button(onClick = {

                                db.collection("applications")
                                    .document(app.id)
                                    .update("status", "rejected")

                            }) {
                                Text("Reject")
                            }

                        }

                    }

                }

            }

        }

    }

}