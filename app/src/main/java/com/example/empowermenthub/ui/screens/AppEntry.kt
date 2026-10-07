package com.example.empowermenthub.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.empowermenthub.ui.navigation.NavGraph

@Composable
fun AppEntry(navController: NavHostController) {
    NavGraph(navController)
}