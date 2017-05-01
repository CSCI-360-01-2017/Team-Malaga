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
     * Test of next method, of class Receiver.
     */
    @Test
    public void testNext() {
        //similiar to isClearStation in broadcastEmulator test
        System.out.println("next");
        Receiver instance = new Receiver("AM", 535, 1705, 10, false);
        instance.prev();
        instance.prev();
        int before = instance.getCurrent();
        instance.next();
        int after = instance.getCurrent();
        assertTrue(before < after);
    }

    /**
     * Test of prev method, of class Receiver.
     */
    @Test
    public void testPrev() {
        //similiar to isClearStation in broadcastEmulator test
        System.out.println("prev");
        Receiver instance = new Receiver("AM", 535, 1705, 10, false);
        instance.next();
        instance.next();
        int before = instance.getCurrent();
        instance.prev();
        int after = instance.getCurrent();
        assertTrue(before > after);
    }
    
}
