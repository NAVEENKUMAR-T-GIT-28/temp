package com.example.empowermenthub.ui.screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.empowermenthub.data.model.ApplicationModel
import com.example.empowermenthub.data.repository.ApplicationRepository

@Composable
fun ApplyJobButton(
    jobId: String,
    employeeId: String,
    employeeName: String
) {


    val repo = ApplicationRepository()

    Button(
        onClick = {

            val application = ApplicationModel(
                jobId = jobId,
                employeeId = employeeId,
                employeeName = employeeName
            )

            repo.applyJob(application)

        }
    ) {

        Text("Apply Job")

    }


}
