package com.example.empowermenthub.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.example.empowermenthub.data.model.ApplicationModel

class ApplicationViewModel : ViewModel() {

    private val db = FirebaseFirestore.getInstance()

    // ===============================
    // Employee applies for job
    // ===============================
    fun applyJob(application: ApplicationModel) {

        db.collection("applications")
            .add(application)
    }

    // ===============================
    // Employer fetches applications
    // ===============================
    fun getApplications(onResult: (List<ApplicationModel>) -> Unit) {

        db.collection("applications")
            .get()
            .addOnSuccessListener { result ->

                val list = mutableListOf<ApplicationModel>()

                for (doc in result.documents) {
                    val application = doc.toObject(ApplicationModel::class.java)
                    if (application != null) {
                        list.add(application)
                    }
                }

                onResult(list)
            }
    }
}