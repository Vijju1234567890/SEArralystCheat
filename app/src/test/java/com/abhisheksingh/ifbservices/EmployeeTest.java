package com.abhisheksingh.ifbservices;

import android.os.Parcel;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.xml.transform.Result;
import java.sql.*;


import static org.junit.Assert.*;

/**
 * Created by abhis on 30-04-2018.
 */
public class EmployeeTest {

    org.junit.runner.Result rs;
    @Test
    public void getUsername() throws Exception {
        for(int i=0;i<FirstPage.employees.size();i++)
        {
            String r = FirstPage.employees.get(i).getUsername();
            assertTrue(r.length() > 0);
            assertEquals(r,FirstPage.employees.get(i).getUsername());
        }

    }

    @Test
    public void getPassword() throws Exception {

        for(int i=0;i<FirstPage.employees.size();i++)
        {
            String r = FirstPage.employees.get(i).getPassword();
            assertTrue(r.length() > 0);
            assertEquals(r,FirstPage.employees.get(i).getPassword());
        }
    }

    @Test
    public void getName() throws Exception {
        for(int i=0;i<FirstPage.employees.size();i++)
        {
            String r = FirstPage.employees.get(i).getName();
            assertTrue(r.length() > 0);
            assertEquals(r,FirstPage.employees.get(i).getName());
        }

    }

    @Test
    public void getJob() throws Exception {
        for(int i=0;i<FirstPage.employees.size();i++)
        {
            String r = FirstPage.employees.get(i).getJob();
            assertTrue(r.length() > 0);
            assertEquals(r,FirstPage.employees.get(i).getJob());
        }
    }

    @Test
    public void getId() throws Exception {
        for(int i=0;i<FirstPage.employees.size();i++)
        {
            int r = FirstPage.employees.get(i).getId();
            assertEquals(r,i+1);
        }
    }

    @Test
    public void getRating() throws Exception {
        for(int i=0;i<FirstPage.employees.size();i++)
        {
            float r = FirstPage.employees.get(i).getRating();
            assertTrue(r>=0 && r<=5.00001);
        }
    }

    @Test
    public void getTask() throws Exception {
        for(int i=0;i<FirstPage.employees.size();i++)
        {
            String r = FirstPage.employees.get(i).getTask();
            assertTrue(r.length() > 0);
            assertEquals(r,FirstPage.employees.get(i).getTask());
        }
    }

    @Test
    public void LoginCheck() throws Exception{
        for(int i=0;i<FirstPage.employees.size();i++)
        {
            for(int j=0;j<FirstPage.employees.size();j++)
            {
                Employee a=FirstPage.employees.get(i);
                Employee b=FirstPage.employees.get(j);
                String userA=a.getUsername();
                String passA=a.getPassword();
                String userB=b.getUsername();
                String passB=b.getPassword();
                if(userB.equals(LoginPage.user_emp[i]) && userB.equals(LoginPage.user_emp[j]))
                    assertTrue(i==j);
            }
        }
    }

    @Test
    public void JobCheck()
    {
        for(int i=0;i<FirstPage.employees.size();i++)
        {
            String r = FirstPage.employees.get(i).getJob();
            assertTrue(r.length() > 0);
            assertEquals(r,FirstPage.job[i%5]);
        }
    }




}