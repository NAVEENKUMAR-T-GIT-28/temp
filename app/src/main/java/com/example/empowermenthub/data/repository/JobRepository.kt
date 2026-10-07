package com.example.empowermenthub.data.repository

import com.example.empowermenthub.data.model.Job
import com.google.firebase.firestore.FirebaseFirestore

class JobRepository {

    private val db = FirebaseFirestore.getInstance()

    fun postJob(job: Job) {

        db.collection("jobs")
            .document(job.id)
            .set(job)
    }

    fun getJobs(onResult: (List<Job>) -> Unit) {

        db.collection("jobs")
            .get()
            .addOnSuccessListener {

                val jobs = it.toObjects(Job::class.java)

                onResult(jobs)
            }
    }
}