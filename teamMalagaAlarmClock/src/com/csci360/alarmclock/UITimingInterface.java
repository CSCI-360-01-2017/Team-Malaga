/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock;

/**
 *
 * @author Eric
 */
public interface UITimingInterface {
    
    public void updateMilitaryTime(int hours, int minutes);
    public void updateAMPMTime(int hours, int minutes, boolean isAM);
    
}
