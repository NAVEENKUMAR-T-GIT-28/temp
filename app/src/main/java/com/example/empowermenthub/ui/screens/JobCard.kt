package com.example.empowermenthub.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.empowermenthub.data.model.Job

@Composable
fun JobCard(job: Job) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Column(modifier = Modifier.padding(16.dp)) {

            Text(job.title)

            Spacer(modifier = Modifier.height(6.dp))

            Text(job.description)

            Spacer(modifier = Modifier.height(6.dp))

            Text("Salary: ${job.salary}")

            Spacer(modifier = Modifier.height(6.dp))

            Text("Location: ${job.location}")

            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = { }) {
                Text("Apply Job")
            }
        }
    }
}