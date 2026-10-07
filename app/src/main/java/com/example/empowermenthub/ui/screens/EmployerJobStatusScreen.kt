package com.example.empowermenthub.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.empowermenthub.data.model.Job
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun EmployerJobStatusScreen() {

    val db = FirebaseFirestore.getInstance()

    var jobs by remember { mutableStateOf<List<Job>>(emptyList()) }

    LaunchedEffect(true) {

        db.collection("jobs")
            .get()
            .addOnSuccessListener {

                val list = mutableListOf<Job>()

                for (doc in it) {

                    val job = doc.toObject(Job::class.java)
                    job.id = doc.id

                    list.add(job)
                }

                jobs = list
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("Your Posted Jobs")

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn {

            items(jobs) { job ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(job.title)
                        Text(job.description)
                        Text("Status: ${job.status}")

                        Spacer(modifier = Modifier.height(10.dp))

                        Button(onClick = {

                            db.collection("jobs")
                                .document(job.id)
                                .update("status", "completed")

                        }) {
                            Text("Mark Job Done")
                        }

                    }

                }

            }

        }

    }

}