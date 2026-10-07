package com.example.empowermenthub.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.empowermenthub.ui.screens.*

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = "roleSelect"
    ) {

        // Role Selection
        composable("roleSelect") {
            RoleSelectScreen(navController)
        }

        // Employee Auth
        composable("employeeLogin") {
            EmployeeLoginScreen(navController)
        }

        composable("employeeRegister") {
            EmployeeRegisterScreen(navController)
        }

        // Employer Auth
        composable("employerLogin") {
            EmployerLoginScreen(navController)
        }

        composable("employerRegister") {
            EmployerRegisterScreen(navController)
        }

        // Employee Details
        composable("employeeDetails") {
            EmployeeDetailsScreen(navController)
        }

        // Employer Details
        composable("employerDetails") {
            EmployerDetailsScreen(navController)
        }

        // Dashboards
        composable("employeeDashboard") {
            EmployeeDashboard(navController)
        }

        composable("employerDashboard") {
            EmployerDashboard(navController)
        }

        // Job Features
        composable("jobList") {
            JobListScreen(navController)
        }

        composable("postJob") {
            PostJobScreen(navController)
        }

        composable("employerApplications") {
            EmployerApplicationsScreen()
        }

        composable("viewApplications") {
            EmployerApplicationsScreen()
        }

        composable("jobStatus") {
            EmployerJobStatusScreen()
        }

        composable("feedback") {
            EmployeeFeedbackScreen()
        }
    }
}