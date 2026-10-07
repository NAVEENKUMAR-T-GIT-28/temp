package com.example.empowermenthub.data.repository

import com.example.empowermenthub.data.model.Job

class FirebaseRepository {

    private val jobList = mutableListOf<Job>()

    fun postJob(job: Job) {
        jobList.add(job)
    }

    fun getJobs(): List<Job> {
        return jobList
    }
}