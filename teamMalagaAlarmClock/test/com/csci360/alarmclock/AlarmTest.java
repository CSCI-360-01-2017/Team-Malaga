/*
 *  Assignment for CSCI 360, created by Team Malaga.
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
    
    Alarm testingAlarm;
    Controller testingController;
    UITimingInterface ui;
    
    public AlarmTest() {
        this.ui = new TestUI();
        this.testingController = new Controller(ui);
        this.testingAlarm = new Alarm(testingController);
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
        testingAlarm.disableAlarm();
        assertFalse(testingAlarm.getEnabled());
    }

    /**
     * Test of activate method, of class Alarm.
     */
    @Test
    public void testActivate() {
        System.out.println("activate");
        testingAlarm.activate();
        assertTrue(testingAlarm.isSounding());
    }

    /**
     * Test of createAlarm method, of class Alarm.
     */
    @Test
    public void testCreateAlarmMidnight() {
        System.out.println("createAlarmMidnight");
        int hours = 0;
        int minutes = 0;
        boolean AMTruePMFalse = true;
        boolean isMilitaryTime = false;
        testingAlarm.setAlarm(hours, minutes,  AMTruePMFalse, isMilitaryTime);
        assertEquals(hours, testingAlarm.getAlarmTime().getHours());
        assertEquals(minutes, testingAlarm.getAlarmTime().getMinutes());
    }
    
    /**
     * Test of createAlarm method, of class Alarm.
     */
    @Test
    public void testCreateAlarmMilitaryTimeMidnight() {
        System.out.println("createAlarmMilitaryTimeMidnight");
        int hours = 0;
        int minutes = 0;
        boolean AMTruePMFalse = false;
        boolean isMilitaryTime = true;
        testingAlarm.setAlarm(hours, minutes, AMTruePMFalse, isMilitaryTime);
        assertEquals(hours, testingAlarm.getAlarmTime().getHours());
        assertEquals(minutes, testingAlarm.getAlarmTime().getMinutes());
    }
    
    /**
     * Test of createAlarm method, of class Alarm.
     */
    @Test
    public void testCreateAlarmSnoozeTime() {
        System.out.println("createAlarmSnoozeTime");
        int hours = 0;
        int minutes = 0;
        boolean repeat = false;
        boolean AMTruePMFalse = true;
        boolean isMilitaryTime = false;
        testingAlarm.setAlarm(hours, minutes, AMTruePMFalse, isMilitaryTime);
        assertEquals(hours, testingAlarm.getSnoozeTime().getHours());
        assertEquals(minutes, testingAlarm.getSnoozeTime().getMinutes());
        assertEquals(repeat, testingAlarm.isRepeat());
   
    }

    
}
