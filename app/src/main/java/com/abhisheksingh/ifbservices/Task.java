package com.abhisheksingh.ifbservices;

/**
 * Created by abhis on 28-04-2018.
 */

/* Here, we define tasks.
Each task will have
-a start time
-an end time
-a description
-a separate variable to store "expertise" or type of technician needed.

The class will contain appropriate constructors and accessor methods as per need. Parameters.Variables are declared private
for security reasons
 */
public class Task {
    private long startTime, endTime;
    private int id,eid;
    private String expertise,description;

    /*Constructor to make required objects*/
    Task(int start,int end,int id,String expertise,String desc,int eid)
    {
        this.startTime=start;
        this.endTime=end;
        this.expertise=expertise;
        this.description=desc;
        this.id=id;
        this.eid=eid;
    }

    /*Accessor methods to get values/states of member parameters*/
    public long getStartTime()
    {
        return this.startTime;
    }
    public long getEndTime()
    {
        return this.endTime;
    }
    public String getExpertise()
    {
        return this.expertise;
    }
    public String getDescription()
    {
        return this.description;
    }
    public int getId() {
        return id;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public void setStartTime(long t)
    {
        this.startTime=t;
    }
    public void setEndTime(long t)
    {
        this.endTime=t;
    }
}
