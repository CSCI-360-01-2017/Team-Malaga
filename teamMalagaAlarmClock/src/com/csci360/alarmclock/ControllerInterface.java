/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock;

import java.util.Calendar;

/**
 *
 * @author Eric
 */
public interface ControllerInterface {
    
    public void soundAlarm(Alarm a);
    public void updateTime(Calendar cal);
}
