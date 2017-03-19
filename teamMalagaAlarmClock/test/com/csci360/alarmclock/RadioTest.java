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
 * @author hotdog
 */
public class RadioTest {
    
    public RadioTest() {
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
     * Test of switchReceiver method, of class Radio.
     */
    @Test
    public void testSwitchReceiver() {
        System.out.println("switchReceiver");
        Radio instance = new Radio();
        instance.switchReceiver();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nextStation method, of class Radio.
     */
    @Test
    public void testNextStation() {
        System.out.println("nextStation");
        Radio instance = new Radio();
        instance.nextStation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prevStation method, of class Radio.
     */
    @Test
    public void testPrevStation() {
        System.out.println("prevStation");
        Radio instance = new Radio();
        instance.prevStation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStation method, of class Radio.
     */
    @Test
    public void testGetStation() {
        System.out.println("getStation");
        Radio instance = new Radio();
        int expResult = 0;
        int result = instance.getStation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of incrementVolume method, of class Radio.
     */
    @Test
    public void testIncrementVolume() {
        System.out.println("incrementVolume");
        Radio instance = new Radio();
        instance.incrementVolume();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decrementVolume method, of class Radio.
     */
    @Test
    public void testDecrementVolume() {
        System.out.println("decrementVolume");
        Radio instance = new Radio();
        instance.decrementVolume();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVolume method, of class Radio.
     */
    @Test
    public void testGetVolume() {
        System.out.println("getVolume");
        Radio instance = new Radio();
        int expResult = 0;
        int result = instance.getVolume();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    /**
     * Test of stop method, of class Radio.
     */
    @Test
    public void testStop() {
        System.out.println("stop");
        Radio instance = new Radio();
        instance.stop();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOn method, of class Radio.
     */
    @Test
    public void testGetOn() {
        System.out.println("getOn");
        Radio instance = new Radio();
        boolean expResult = false;
        boolean result = instance.getOn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOn method, of class Radio.
     */
    @Test
    public void testSetOn() {
        System.out.println("setOn");
        boolean on = false;
        Radio instance = new Radio();
        instance.setOn(on);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playBroadcast method, of class Radio.
     */
    @Test
    public void testPlayBroadcast() {
        System.out.println("playBroadcast");
        Radio instance = new Radio();
        instance.playBroadcast();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class Radio.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Radio instance = new Radio();
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
