/*
 * Assignment for CSCI 360, created by Team Malaga.
 */
package com.csci360.alarmclock;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Team-Malaga
 */
public class AlarmTest {
    
    public AlarmTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of disableAlarm method, of class Alarm.
     */
    @Test
    public void testDisableAlarm() {
        System.out.println("disableAlarm");
        Alarm instance = null;
        instance.disableAlarm();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of snoozeAlarm method, of class Alarm.
     */
    @Test
    public void testSnoozeAlarm() {
        System.out.println("snoozeAlarm");
        Alarm instance = null;
        instance.snoozeAlarm();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of activate method, of class Alarm.
     */
    @Test
    public void testActivate() {
        System.out.println("activate");
        Alarm instance = null;
        instance.activate();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createAlarm method, of class Alarm.
     */
    @Test
    public void testCreateAlarm() {
        System.out.println("createAlarm");
        int hours = 0;
        int minutes = 0;
        boolean repeat = false;
        String am_pm = "";
        boolean isMilitaryTime = false;
        Alarm instance = null;
        instance.createAlarm(hours, minutes, repeat, am_pm, isMilitaryTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createOffset method, of class Alarm.
     */
    @Test
    public void testCreateOffset() {
        System.out.println("createOffset");
        Alarm instance = null;
        instance.createOffset();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
