package com.abhisheksingh.ifbservices;

import org.junit.Test;

import static com.abhisheksingh.ifbservices.AdministratorPage.cost;
import static com.abhisheksingh.ifbservices.AdministratorPage.duration;
import static com.abhisheksingh.ifbservices.AdministratorPage.end;
import static com.abhisheksingh.ifbservices.AdministratorPage.rate;
import static com.abhisheksingh.ifbservices.AdministratorPage.rate;
import static com.abhisheksingh.ifbservices.AdministratorPage.rate;
import static com.abhisheksingh.ifbservices.AdministratorPage.st;
import static org.junit.Assert.*;

/**
 * Created by abhis on 30-04-2018.
 */
public class AdministratorPageTest {

    @Test
    public void CheckRate() throws Exception {
        int n=AdministratorPage.n;
        for(int i=0;i<n;i++)
        {
            assertTrue(rate[i]>0);
        }
    }

    @Test
    public void CheckDuration() throws Exception {
        int n=AdministratorPage.n;
        for(int i=0;i<n;i++)
        {
            assertTrue(duration[i]>=0);
        }
    }
    @Test
    public void CheckCost() throws Exception{
        int n=AdministratorPage.n;
        for(int i=0;i<n;i++)
        {
            assertTrue(cost[i]==(end[i]-st[i])*rate[i]);
        }
    }

}