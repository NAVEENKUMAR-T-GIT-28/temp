package com.example.empowermenthub.data.model

data class Job(
    var id: String = "",
    var title: String = "",
    var description: String = "",
    var location: String = "",
    var salary: String = "",
    var employerId: String = "",
    var status: String = "open"
)