/*
 *  Assignment for CSCI 360, created by Team Malaga.
 */


package com.csci360.alarmclock;
 

import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;

/**
 *
 * @author Team-Malaga
 */
public class Alarm {
    
    private boolean repeat;
    private Controller sysController;
    private Date alarmTime;
    private boolean disableAlarm;
    private Date snoozeTime;
    
    /**
     *
     *  Constructor for Alarm, it needs an instance of a controller to which
     *  it can send the sound alarm signal.
     */
    public Alarm(Controller c) {
        this.sysController = c;
        this.repeat = false;
        this.disableAlarm = false;
        
    }
    
    
    
    /**
     * The alarm has been disabled and will not activate
     * 
     */
    public void disableAlarm(){
        this.disableAlarm = true;
    }
    
    
    
    /**
     * The alarm has been snoozed and will sound again in 10 minutes. 
     * 
     */
    public void snoozeAlarm(){
        Date tempTime = new Date();
        tempTime.setTime(alarmTime.getTime());
        snoozeTime.setMinutes(snoozeTime.getMinutes() + 10);
        alarmTime = snoozeTime;
        createOffset();
        alarmTime = tempTime;
                
            
    }
    
    /**
     * activate is called when the designated alarm time has been reached and 
     * the alarm has not been disabled.
     */
    public void activate(){
        
        if(!disableAlarm){

            if (repeat){
                alarmTime.setDate(alarmTime.getDate()+1);
                createOffset();
            }
            
             sysController.soundAlarm(this);
        }

    }
    
    /**
     * an alarm is created to sound at a set number of hours and minutes
     * within the next 24 hours.
     */
    public void createAlarm(int hours, int minutes, boolean repeat, String am_pm, boolean isMilitaryTime){
        this.repeat = repeat;
        alarmTime = new Date();
        this.disableAlarm = false;
        
        if (isMilitaryTime){
            alarmTime.setHours(hours);
            alarmTime.setMinutes(minutes);
            if(alarmTime.before(new Date())){
                alarmTime.setDate(alarmTime.getDate() + 1);
            }
        }
        else{
                            
            if (am_pm == "am"){
                alarmTime.setHours(hours);
                alarmTime.setMinutes(minutes);
                if(alarmTime.before(new Date())){
                    alarmTime.setDate(alarmTime.getDate() + 1);
                }
            }
            if(am_pm == "pm"){
                alarmTime.setHours(hours + 12);
                alarmTime.setMinutes(minutes);
                if(alarmTime.before(new Date())){
                    alarmTime.setDate(alarmTime.getDate() + 1);
                }
            }
        }
        snoozeTime = alarmTime;

        createOffset();

    }
    
    /**
     * the time until the alarm sounds is dictated through a Timer.
     */
    public void createOffset(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                activate();
            }
        }, alarmTime);
    }
    
}
