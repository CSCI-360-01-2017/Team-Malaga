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
public class ReceiverTest {
    
    public ReceiverTest() {
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
     * Test of getId method, of class Receiver.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Receiver instance = null;
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentFreq method, of class Receiver.
     */
    @Test
    public void testGetCurrentFreq() {
        System.out.println("getCurrentFreq");
        Receiver instance = null;
        int expResult = 0;
        int result = instance.getCurrentFreq();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentFreqString method, of class Receiver.
     */
    @Test
    public void testGetCurrentFreqString() {
        System.out.println("getCurrentFreqString");
        Receiver instance = null;
        String expResult = "";
        String result = instance.getCurrentFreqString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of next method, of class Receiver.
     */
    @Test
    public void testNext() {
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
        System.out.println("prev");
        Receiver instance = null;
        instance.prev();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
