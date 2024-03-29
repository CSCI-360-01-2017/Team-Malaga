/*
 * Assignment for CSCI 360, created by Team Malaga.
 * This class controls volume, station, and receiver of a fabricated radio.
 */
package com.csci360.alarmclock;

/**
 * A radio is a device for listening to broadcasts.  It uses two receivers
 * to pick up either AM or FM signals, and has a range of volumes at which these
 * signals can be played.
 * 
 * @author Team-Malaga
 */
public class Radio {
    /**
     * an array of 2 receivers, AM and FM.
     */
    private final Receiver[] receivers = new Receiver[2];
    /**
     * the current receiver being used by the radio.
     */
    private Receiver currentReceiver;
    /**
     * the minimum volume the radio can be set to.
     */
    private final int minVol;
    /**
     * the maximum volume the radio can be set to.
     */
    private final int maxVol;
    /**
     * the current volume the radio is set to.
     */
    private int currentVol;
    /**
     * boolean on is true when the radio is on and playing, false otherwise.
     */
    private boolean on;
    
    /**
     * constructor for a radio. A new radio should have an AM and FM receiver.
     * Its initial modulation should be set to FM.
     */
    public Radio(){
        receivers[0] = new Receiver("AM", 535, 1705, 10, false);
        receivers[1] = new Receiver("FM", 87500, 108000, 200, true);
        currentReceiver = receivers[1];
        minVol = 0;
        maxVol = 11;
        currentVol = 5;
        on = false;
    }
    
    /**
     * returns the receiver object currently in use
     * @return the current receiver
     */
    public Receiver getReceiver(){
        return this.currentReceiver;
    }
    
    /**
     * switches the currently listening receiver from one to another.
     */
    public void switchReceiver(){
        
        currentReceiver = receivers[(java.util.Arrays.asList(receivers).indexOf(currentReceiver)+1)%2];
        // keep below logic until certain that the new logic works
        //if (currentReceiver.equals(receivers[1])){
        //    currentReceiver = receivers[0];
        //}
        //else{ 
        //    //if (currentReceiver.equals(receivers[0]))
        //    currentReceiver = receivers[1];
        //}
    }
    
    /**
     * calls to the receiver that is designated by the currentReceiver and  
     * increments the current frequency until finding a viable broadcast.
     */
    public void nextStation(){
        this.currentReceiver.next();
    }
    
    /**
     * calls to the receiver that is designated by the currentReceiver and  
     * decrements the current frequency until finding a viable broadcast.
     */
    public void prevStation(){
        this.currentReceiver.prev();
    }
    
    /**
     * calls to the receiver that is designated by the currentReceiver and  
     * retrieves the current frequency being played in kHz, expressed as an int.
     * @return 
     */
    public int getStation(){
        return this.currentReceiver.getCurrent();
    }

    /**
     * increases the volume by 1. if the volume is at max, it remains at max.
     */
    public void incrementVolume(){
        if(this.currentVol < this.maxVol){
            this.currentVol++;
        } 
    }
    
    /**
     * decreases the volume by 1. if the volume is at min, it remains at min.
     */
    public void decrementVolume(){
        if(this.currentVol > this.minVol){
            this.currentVol--;
        }
    }
    
    /**
     * returns the current volume of the radio
     * @return the current volume of the radio
     */
    public int getVolume(){
        return this.currentVol;
    }
    
    /**
     * returns the on status of the radio
     * @return true if the radio is on, off if otherwise.
     */
    public boolean getOn(){
        return this.on;
    }
    
    /**
     * sets the on status of the radio
     * @param on the new status of the radio
     */
    public void setOn(boolean on){
        this.on = on;
    }
    
    /**
     * Emulate the playing of a radio station using a print statement.
     * @return 
     */
    public String playBroadcast(){
        return String.format("Playing %s broadcast from station %s at volume %d\n", this.currentReceiver.getId(), this.currentReceiver.getCurrentFormattedString(), this.getVolume());       
    }
    
    /**
     * Starts the playing of the radio.
     */
    public void start(){
        setOn(true);
    }
    
    /**
     * Stops the playing of the radio.
     */
    public void stop(){
        setOn(false);
    }
}
