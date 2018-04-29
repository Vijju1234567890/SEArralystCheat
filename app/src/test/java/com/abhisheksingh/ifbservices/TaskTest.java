package com.abhisheksingh.ifbservices;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by abhis on 30-04-2018.
 */
public class TaskTest {
    //Task(int start,int end,int id,String expertise,String desc,int eid)
    @Test
    public void getStartTime() throws Exception {
        Task t=new Task(10,0,0,null,null,0);
        assertTrue(t.getStartTime()==10);
    }

    @Test
    public void getEndTime() throws Exception {
        Task t=new Task(10,20,0,null,null,0);
        assertTrue(t.getEndTime()==20);
    }

    @Test
    public void getExpertise() throws Exception {
        Task t=new Task(10,20,0,"Tested",null,0);
        assertTrue(t.getExpertise().equals("Tested"));
    }

    @Test
    public void getDescription() throws Exception {
        Task t=new Task(10,20,0,"Tested","Desc",0);
        assertTrue(t.getDescription().equals("Desc"));
    }

    @Test
    public void getId() throws Exception {
        Task t=new Task(10,20,10,"Tested",null,0);
        assertTrue(t.getId()==10);
    }

    @Test
    public void getEid() throws Exception {
        Task t=new Task(10,20,10,"Tested",null,101);
        assertTrue(t.getEid()==101);
}

    @Test
    public void setEid() throws Exception {
        Task t=new Task(10,20,10,"Tested",null,0);
        t.setEid(50);
        assertTrue(t.getEid()==50);
    }

    @Test
    public void setStartTime() throws Exception {
        Task t=new Task(10,20,10,"Tested",null,0);
        t.setStartTime(15);
        assertTrue(t.getStartTime()==15);
    }

    @Test
    public void setEndTime() throws Exception {
        Task t=new Task(10,20,10,"Tested",null,0);
        t.setEndTime(30);
        assertTrue(t.getEndTime()==30);
    }
}