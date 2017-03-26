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
public class ReceiverTest {
    
    public ReceiverTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getCurrentFormattedString method, of class Receiver.
     */
    @Test
    public void testGetCurrentFormattedString() {
        System.out.println("getCurrentFormattedString");
        Receiver instance = null;
        String expResult = "";
        String result = instance.getCurrentFormattedString();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of next method, of class Receiver.
     */
    //@Test
    public void testNext() {
        System.out.println("next");
        Receiver instance = null;
        System.out.println("Current good signal is " + instance.getBroadcastEmulator());
        instance.next();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println("New good signal is " + instance.getBroadcastEmulator());

    }

    /**
     * Test of prev method, of class Receiver.
     */
    @Test
    public void testPrev() {
        System.out.println("prev");
        Receiver instance = null;
        System.out.println("Current good signal is " + instance.getBroadcastEmulator());
        instance.prev();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println("New good signal is " + instance.getBroadcastEmulator());

    }
    
}
