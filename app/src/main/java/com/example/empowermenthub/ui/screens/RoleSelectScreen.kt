package com.example.empowermenthub.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun RoleSelectScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Select Role", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { navController.navigate("employeeLogin") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Employee Login")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("employerLogin") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Employer Login")
        }
    }
}