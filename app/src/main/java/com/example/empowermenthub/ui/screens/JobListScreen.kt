package com.example.empowermenthub.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.empowermenthub.data.model.Job
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun JobListScreen(navController: NavController) {

    val db = FirebaseFirestore.getInstance()

    var jobs by remember { mutableStateOf<List<Job>>(emptyList()) }

    LaunchedEffect(true) {

        db.collection("jobs")
            .get()
            .addOnSuccessListener { result ->

                val jobList = mutableListOf<Job>()

                for (doc in result) {

                    val job = doc.toObject(Job::class.java)
                    job.id = doc.id   // 🔥 THIS LINE FIXES job.id ERROR

                    jobList.add(job)
                }

                jobs = jobList
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Available Jobs",
            style = MaterialTheme.typography.titleLarge
        )

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

                        Text(text = "Title: ${job.title}")
                        Text(text = "Location: ${job.location}")
                        Text(text = "Salary: ${job.salary}")
                        Text(text = "Description: ${job.description}")

                        Spacer(modifier = Modifier.height(10.dp))

                        Button(onClick = {

                            val employeeId = "employee123" // later we use FirebaseAuth

                            val application = hashMapOf(
                                "jobId" to job.id,
                                "employeeId" to employeeId,
                                "employeeName" to "Employee Name",
                                "status" to "pending"
                            )

                            db.collection("applications")
                                .add(application)

                        }) {
                            Text("Apply Job")
                        }

                    }

                }

            }

        }

    }

}