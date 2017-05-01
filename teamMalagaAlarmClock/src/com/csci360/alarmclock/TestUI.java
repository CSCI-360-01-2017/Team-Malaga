/*
 *  Assignment for CSCI 360, created by Team Malaga.
 *
 *  THIS CLASS ONLY EXISTS FOR TESTING PURPOSES
 *
 *  This class exists to have an instantiatable UI class that can be passed into
 *  the controller while testing things like alarm.activate().
 */
package com.csci360.alarmclock;

/**
 *
 * @author Team-Malaga
 */
public class TestUI implements UITimingInterface{

    
    /**
     * This method does nothing, just to give the controller somewhere to update
     * the clock time for testing purposes.
     * @param hours
     * @param minutes 
     */
    @Override
    public void updateMilitaryTime(int hours, int minutes) {
        
    }

    /**
     * This method does nothing, just to give the controller somewhere to update
     * the clock time for testing purposes.
     * @param hours
     * @param minutes
     * @param isAM 
     */
    @Override
    public void updateAMPMTime(int hours, int minutes, boolean isAM) {
        
    }

    /**
     * This method does nothing, just to give the controller somewhere to send
     * the message that an alarm is sounding
     * @param alarmNum 
     */
    @Override
    public void soundAlarm(int alarmNum) {
        
    }
    
}
