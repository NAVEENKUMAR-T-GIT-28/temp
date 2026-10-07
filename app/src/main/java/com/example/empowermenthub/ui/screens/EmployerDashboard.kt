package com.example.empowermenthub.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height


@Composable
fun EmployerDashboard(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Employer Dashboard",
            style = MaterialTheme.typography.headlineMedium
        )

        Button(
            onClick = {
                navController.navigate("postJob")
            },
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text("Post Job")
        }

        Button(
            onClick = { navController.navigate("viewApplications") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("View Applications")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("jobStatus") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Manage Jobs")
        }

    }
}