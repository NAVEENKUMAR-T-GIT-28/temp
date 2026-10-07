package com.example.jobapp.model;

public class Job {

    private String title;
    private String description;
    private String salary;
    private String location;
    private String employerId;

    public Job(){}

    public Job(String title,String description,String salary,String location,String employerId){
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.location = location;
        this.employerId = employerId;
    }

    public String getTitle() { return title; }

    public String getDescription() { return description; }

    public String getSalary() { return salary; }

    public String getLocation() { return location; }

    public String getEmployerId() { return employerId; }

    public void setTitle(String title) { this.title = title; }

    public void setDescription(String description) { this.description = description; }

    public void setSalary(String salary) { this.salary = salary; }

    public void setLocation(String location) { this.location = location; }

    public void setEmployerId(String employerId) { this.employerId = employerId; }
}