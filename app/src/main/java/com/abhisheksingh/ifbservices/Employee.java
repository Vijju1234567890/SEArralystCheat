package com.abhisheksingh.ifbservices;

import java.io.FileWriter;

/**
 * Created by abhis on 28-04-2018.
 */
/*
Here we define the Employee Class
Each employee will have
-A username
-A password
-An actual name
-A job title (expertise)
-Task currently assigned/doing
-An id (numeric)
-A rating

The class will contain appropriate constructors and accessor methods as per need. Parameters.Variables are declared private
for security reasons
 */
public class Employee {

    private String username,password,name,job,task;
    private int id;
    private float rating;

   /*Cosntructor to make objects*/
    Employee(String username, String pass, String name, String job, String task, int id, float ratings)
    {
        this.username=username;
        this.password=pass;
        this.name=name;
        this.job=job;
        this.id=id;
        this.rating=ratings;
        this.task=task;
    }
    /*Public Methods to gain access to required variables. Named as per JAVAFX conventions*/
    public String getUsername()
    {
        return this.username;
    }
    public String getPassword()
    {
        return this.password;
    }
    public String getName()
    {
        return this.name;
    }
    public String getJob()
    {    return this.job;    }
    public int getId()
    {
        return this.id;
    }
    public float getRating()
    {
        return this.rating;
    }
    public String getTask()
    {
        return this.task;
    }
    public void print(FileWriter f) throws Exception
    {
       f.append(username+" "+password+" "+name+" "+job+" "+task+" "+id+" "+rating);
    }
    public void setTask(String s)
    {
        this.task=s;
    }
}
