/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock;


import java.util.Timer;
import java.util.TimerTask;



/**
 *
 * @author Eric
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
