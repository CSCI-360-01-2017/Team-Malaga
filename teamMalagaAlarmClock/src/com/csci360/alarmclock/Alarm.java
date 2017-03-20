/*
 *  Assignment for CSCI 360, created by Team Malaga.
 */


package com.csci360.alarmclock;
 

import java.util.Timer;
import java.util.TimerTask;



/**
 *
 * @author Team-Malaga
 */
public class Alarm {
    
    private boolean repeat = false;
    
    public Alarm() {
        
        

        
    }
    
    public void activate(){
        if (repeat == true){
            createOffset();
            
        }
    }
    
    public void createAlarm(){
        
    }
    
    public void createOffset(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                activate();
            }
        }, 0);
    }
    
}