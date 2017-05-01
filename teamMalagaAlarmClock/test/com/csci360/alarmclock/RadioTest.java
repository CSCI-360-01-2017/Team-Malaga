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
    
    //TODO for each test method is below
    
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
        //TODO test that the Receiver is not the same before and after switching.
        //test that the Receiver IS the same after switching twice.
        System.out.println("switchReceiver");
        Radio instance = new Radio();
        Receiver before = instance.getReceiver();
        instance.switchReceiver();
        Receiver after = instance.getReceiver();
        assertNotEquals(before, after);
    }

    /**
     * Test of nextStation method, of class Radio.
     */
    @Test
    public void testNextStation() {
        //TODO test that the station afterwards is either greater than the current station,
        //or that it has looped back to the first viable station (may be tricky!)
        System.out.println("nextStation");
        Radio instance = new Radio();
        int before = instance.getStation();
        instance.nextStation();
        int after = instance.getStation();
        assertTrue(after >= before);
    }

    /**
     * Test of prevStation method, of class Radio.
     */
    @Test
    public void testPrevStation() {
        //TODO test that the station afterwards is either less than the current station,
        //or that it has looped back to the last viable station (may be tricky!)
        //could also test that a subsequent call to nextStation will go back to the starting point.
        System.out.println("prevStation");
        Radio instance = new Radio();
        int before = instance.getStation();
        instance.prevStation();
        int after = instance.getStation();
        assertTrue(after <= before);
    }

    /**
     * Test of incrementVolume method, of class Radio.
     */
    @Test
    public void testIncrementVolume() {
        //TODO test that the volume has increased or is at max(11)
        System.out.println("incrementVolume");
        Radio instance = new Radio();
        int before = instance.getVolume();
        instance.incrementVolume();
        int after = instance.getVolume();
        assertTrue(after >= before);
    }

    /**
     * Test of decrementVolume method, of class Radio.
     */
    @Test
    public void testDecrementVolume() {
        //TODO test that the volume has decreased or is at min(11)
        System.out.println("decrementVolume");
        Radio instance = new Radio();
        int before = instance.getVolume();
        instance.decrementVolume();
        int after = instance.getVolume();
        assertTrue(after <= before);
    }

    
}
