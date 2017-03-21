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
        //test that the formatted string matches the numerical value, as formatted
        System.out.println("getCurrentFormattedString");
        Receiver instance = null;
        String expResult = "";
        String result = instance.getCurrentFormattedString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of next method, of class Receiver.
     */
    @Test
    public void testNext() {
        //similiar to isClearStation in broadcastEmulator test
        System.out.println("next");
        Receiver instance = null;
        instance.next();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prev method, of class Receiver.
     */
    @Test
    public void testPrev() {
        //similiar to isClearStation in broadcastEmulator test
        System.out.println("prev");
        Receiver instance = null;
        instance.prev();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
