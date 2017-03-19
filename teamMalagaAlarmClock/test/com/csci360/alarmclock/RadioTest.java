/*
 * Assignment for CSCI 360, created by Team Malaga.
 */
package com.csci360.alarmclock;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Team-Malaga
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
    
}
