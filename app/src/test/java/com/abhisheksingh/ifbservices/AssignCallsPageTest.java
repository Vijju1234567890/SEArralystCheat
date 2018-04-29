package com.abhisheksingh.ifbservices;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by abhis on 30-04-2018.
 */
public class AssignCallsPageTest {
    //static int IdOnTask=0,IdOnTaskAssign=0;
    @Test
    public void checkIdOnTask() throws Exception {
        assertTrue(0<=AssignCallsPage.IdOnTask && AssignCallsPage.IdOnTask<=FirstPage.unassigned.size());
    }

    @Test
    public void checkIdOnTaskAssign() throws Exception {
        assertTrue(0<=AssignCallsPage.IdOnTaskAssign && AssignCallsPage.IdOnTaskAssign<=FirstPage.unassigned.size());
    }

}