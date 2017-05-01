/*
 *  Assignment for CSCI 360, created by Team Malaga.
 */
package com.csci360.alarmclock;

import java.util.Calendar;

/**
 *
 * @author Team-Malaga
 */
public interface ControllerInterface {
    
    public void soundAlarm(Alarm a);
    public void updateTime(Calendar cal);
}
