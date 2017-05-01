/*
 *  Assignment for CSCI 360, created by Team Malaga.
 */
package com.csci360.alarmclock;

/**
 *
 * @author Team-Malaga
 */
public interface UITimingInterface {
    
    public void updateMilitaryTime(int hours, int minutes);
    public void updateAMPMTime(int hours, int minutes, boolean isAM);
    public void soundAlarm(int alarmNum);
    
}
