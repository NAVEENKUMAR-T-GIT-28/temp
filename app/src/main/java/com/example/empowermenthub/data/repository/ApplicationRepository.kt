package com.example.empowermenthub.data.repository

import com.example.empowermenthub.data.model.ApplicationModel
import com.google.firebase.firestore.FirebaseFirestore

class ApplicationRepository {

    private val db = FirebaseFirestore.getInstance()

    fun applyJob(application: ApplicationModel) {

        db.collection("applications")
            .add(application)

    }

    fun getApplicationsForJob(
        jobId: String,
        onResult: (List<ApplicationModel>) -> Unit
    ) {

        db.collection("applications")
            .whereEqualTo("jobId", jobId)
            .get()
            .addOnSuccessListener { result ->

                val list = mutableListOf<ApplicationModel>()

                for (doc in result) {

                    val app = doc.toObject(ApplicationModel::class.java)
                    list.add(app)

                }

                onResult(list)
            }
    }
}