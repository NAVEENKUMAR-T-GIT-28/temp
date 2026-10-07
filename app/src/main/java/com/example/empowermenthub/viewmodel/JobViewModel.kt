package com.example.empowermenthub.viewmodel

import androidx.lifecycle.ViewModel
import com.example.empowermenthub.data.model.Job
import com.example.empowermenthub.data.repository.JobRepository

class JobViewModel : ViewModel() {

    private val repository = JobRepository()

    fun postJob(job: Job) {

        repository.postJob(job)
    }

    fun getJobs(onResult: (List<Job>) -> Unit) {

        repository.getJobs(onResult)
    }
}