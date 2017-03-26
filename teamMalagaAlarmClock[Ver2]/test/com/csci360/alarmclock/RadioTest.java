/*
 * Assignment for CSCI 360, created by Team Malaga.
 */
package com.csci360.alarmclock;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.rules.TestWatcher;
import org.junit.Test.*;
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
        System.out.println("Old Receiver is " + instance.getReceiver());
        instance.switchReceiver();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("New Receiver is " + instance.getReceiver());
    }

    /**
     * Test of nextStation method, of class Radio.
     */
    @Test
    public void testNextStation() {
        System.out.println("nextStation");
        Radio instance = new Radio();
        System.out.println("Old Station is " + instance.getStation());

        instance.nextStation();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println("New Station is " + instance.getStation());

    }

    /**
     * Test of prevStation method, of class Radio.
     */
    @Test
    public void testPrevStation() {
        System.out.println("prevStation");
        Radio instance = new Radio();
        System.out.println("Old Station is " + instance.getStation());

        instance.prevStation();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println("New Station is " + instance.getStation());

    }

    /**
     * Test of incrementVolume method, of class Radio.
     */
    @Test
    public void testIncrementVolume() {
        System.out.println("incrementVolume");
        Radio instance = new Radio();
        System.out.println("Old Volume is " + instance.getVolume());

        instance.incrementVolume();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println("New Volume is " + instance.getVolume());

    }

    /**
     * Test of decrementVolume method, of class Radio.
     */
    @Test
    public void testDecrementVolume() {
        System.out.println("decrementVolume");
        Radio instance = new Radio();
        System.out.println("Old Volume is " + instance.getVolume());

        instance.decrementVolume();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println("New Volume is " + instance.getVolume());

    }

    /**
     * Test of playBroadcast method, of class Radio.
     */
    @Test
    public void testPlayBroadcast() {
        System.out.println("playBroadcast");
        Radio instance = new Radio();
        System.out.println("Old Broadcast is " + instance.getStation());

        instance.playBroadcast();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println("New Broadcast is " + instance.getStation());

    }

    /**
     * Test of start method, of class Radio.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Radio instance = new Radio();
        if (instance.getOn() == true){
            instance.stop();
        }
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        if (instance.getOn() == true){
            System.out.println("Radio successfully turned on.");
        }
    }

    /**
     * Test of stop method, of class Radio.
     */
    @Test
    public void testStop() {
        System.out.println("stop");
        Radio instance = new Radio();
        if (instance.getOn() == false){
            instance.start();
        }
        instance.stop();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        if (instance.getOn() == false){
            System.out.println("Radio successfully turned off.");
        }
    }
    
}
