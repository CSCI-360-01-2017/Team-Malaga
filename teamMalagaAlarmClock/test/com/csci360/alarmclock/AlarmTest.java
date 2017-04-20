/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author Eric
 */
public class AlarmTest {
    
    Alarm testingAlarm;
    Controller testingController;
    UITimingInterface ui;
    
    public AlarmTest() {
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
        assertFalse(testingAlarm.isDisableAlarm());
        testingAlarm.disableAlarm();
        assertTrue(testingAlarm.isDisableAlarm());
    }

    /**
     * Test of activate method, of class Alarm.
     */
    @Test
    public void testActivate() {
        System.out.println("activate");
        testingAlarm.activate();
        assertSame(testingAlarm, testingController.getSoundingAlarm());
    }

    /**
     * Test of createAlarm method, of class Alarm.
     */
    @Test
    public void testCreateAlarmMidnight() {
        System.out.println("createAlarmMidnight");
        int hours = 0;
        int minutes = 0;
        boolean repeat = false;
        boolean AMTruePMFalse = true;
        boolean isMilitaryTime = false;
        testingAlarm.setAlarm(hours, minutes, repeat, AMTruePMFalse, isMilitaryTime);
        assertEquals(hours, testingAlarm.getAlarmTime().getHours());
        assertEquals(minutes, testingAlarm.getAlarmTime().getMinutes());
        assertEquals(repeat, testingAlarm.isRepeat());
    }
    
    /**
     * Test of createAlarm method, of class Alarm.
     */
    @Test
    public void testCreateAlarmMilitaryTimeMidnight() {
        System.out.println("createAlarmMilitaryTimeMidnight");
        int hours = 0;
        int minutes = 0;
        boolean repeat = true;
        boolean AMTruePMFalse = false;
        boolean isMilitaryTime = true;
        testingAlarm.setAlarm(hours, minutes, repeat, AMTruePMFalse, isMilitaryTime);
        assertEquals(hours, testingAlarm.getAlarmTime().getHours());
        assertEquals(minutes, testingAlarm.getAlarmTime().getMinutes());
        assertEquals(repeat, testingAlarm.isRepeat());
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
        testingAlarm.setAlarm(hours, minutes, repeat, AMTruePMFalse, isMilitaryTime);
        assertEquals(hours, testingAlarm.getSnoozeTime().getHours());
        assertEquals(minutes, testingAlarm.getSnoozeTime().getMinutes());
        assertEquals(repeat, testingAlarm.isRepeat());
   
    }

    
}
