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
public class BroadcastEmulatorTest {
    
    //TODO implement tests:  check that there is at least one station, foundStation
    //where foundStation is within the range used to initialize the broadcastEmulator, 
    //and that it is a possible station, i.e. (foundStation-start) is a multiple of (step).
    //This could be done by running isAClearStation on a range of values, and when it returns
    //true, check that the value is one of the possible stations.
    //EXTRA may also test that all values that are either 1) outside of the range or 
    //2) within the range but not a multiple of step return false
    
    
        
    
    public BroadcastEmulatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of isAClearStation method, of class BroadcastEmulator.
     */
    @Test
    public void testIsAClearStation() {
        System.out.println("isAClearStation");
        int frequency = -1;
        BroadcastEmulator instance = new BroadcastEmulator(88,200,20);
        boolean expResult = false;
        boolean result = instance.isAClearStation(frequency);
        assertEquals(expResult, result);

    }
    
}
