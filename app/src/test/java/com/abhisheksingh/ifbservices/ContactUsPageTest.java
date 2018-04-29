package com.abhisheksingh.ifbservices;

import org.junit.Test;

import static com.abhisheksingh.ifbservices.GuestPage.rb;
import static org.junit.Assert.*;

/**
 * Created by abhis on 30-04-2018.
 */
public class ContactUsPageTest {
    @Test
    public void checkRating() throws Exception {
        float a=FirstPage.total,c;
        int b=FirstPage.num;
        if(rb!=null)
        {
            c=rb.getRating();
        }
        else
            c=a/b;
       assertEquals(c,a/b,0.0001);
    }

}