/*
 * Assignment for CSCI 360, created by Team Malaga.
 */
package com.csci360.alarmclock;

/**
 *
 * Receivers are in charge of finding viable broadcast signals.
 * 
 * @author Team-Malaga
 */
public class Receiver {
    
    private final String id;
    private final int min;
    private final int max;
    private final int step;
    private final BroadcastEmulator broadcastEmulator;
    private final boolean displaymHz;
    private int current;
    
    /**
     * constructor for a receiver, which is used to receive radio broadcasts
     * across a spectrum. The receiver must be initialized with a minimum(AM:535,
     * FM: 87500), a maximum (AM: 1705, FM: 108000), a step (AM: 10, FM: 200), and
     * whether or not it needs to be converted to megahertz to display properly.
     * 
     * @param id the abbreviated id for this receiver type, i.e. "AM" or "FM"
     * @param min the minimum frequency this receiver can accept, in kHz
     * @param max the maximum frequency this receiver can accept, in kHz
     * @param step the required distance, in kHz, between broadcasts
     * @param displaymHz a boolean indicating that this receiver should display
     * frequencies in mHz if true(FM) or leave them in kHz if false(AM), according to 
     * display conventions
     */
    public Receiver(String id, int min, int max, int step, boolean displaymHz ){
        this.id = id;
        this.min = min;
        this.max = max;
        this.step = step;
        this.displaymHz = displaymHz;
        this.current = min;
        this.broadcastEmulator = new BroadcastEmulator(min, max, step);
        
    }
    
    /**
     * returns the String id for this receiver, a constant
     * @return the id for this receiver.
     */
    public String getId(){
        return this.id;
    }
    
    /**
     * returns the current frequency
     * @return the current frequency as an integer, in khz.
     */
    public int getCurrentFreq(){
        return this.current;
    }

    /**
     * 
     * @return the current frequency as a string, in the standard format for
     * the receiver's range, either megahertz or kilohertz.
     */
    public String getCurrentFreqString(){
        String display;
        if (this.displaymHz){
            // set the display in the form of "##.#" representing the
            // current frequency in mHz.
            display = String.format("%d.%d", current/1000, (current%1000)/100);
        }
        else{
            //set the display in the form of "###" representing the current
            // frequency in kHz.
            display = String.format("%d", current);
        }
        return display;
    }
    
        
    public void next(){
        boolean found = false;
        while(!found){
            if((current + step) > max){   //has max frequency been reached?
                current = min;      //set to minimum
            }
            else{                   //if not, increment by one step
                current = (current + step);
            }
            if(broadcastEmulator.isAClearStation(current)){
                found = true;
            }
        }
    }
    
    public void prev(){
        boolean found = false;
        while(!found){
            if( (current - step) < max){   //has min frequency been reached?
                current = max;      //set to maximum
            }
            else{                   //if not, decrement by one step
                current = (current - step);
            }
            if(broadcastEmulator.isAClearStation(current)){
                found = true;
            }
        }
    }
}
