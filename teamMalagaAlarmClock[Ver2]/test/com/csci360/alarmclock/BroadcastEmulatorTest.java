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
        int frequency = 0;
        BroadcastEmulator instance = null;
        boolean expResult = false;
        boolean result = instance.isAClearStation(frequency);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
