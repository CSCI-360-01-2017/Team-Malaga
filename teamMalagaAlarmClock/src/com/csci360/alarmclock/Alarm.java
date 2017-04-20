/*
 *  Assignment for CSCI 360, created by Team Malaga.
 */


package com.csci360.alarmclock;
 

import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import javafx.application.Platform;

/**
 *
 * @author Team-Malaga
 */
public class Alarm {
    
    static final int SNOOZE_TIME = 10;
    static final int REPEAT_TIME = 1;
    private boolean repeat;
    private ControllerInterface sysController;
    private Date alarmTime;
    private boolean isEnabled;
    private boolean isSounding;
    private boolean disableAlarm;
    private Date snoozeTime;
    private Timer timer;
    
    /**
     *
     *  Constructor for Alarm, it needs an instance of a controller to which
     *  it can send the sound alarm signal.
     */
    public Alarm(ControllerInterface c) {
        this.sysController = c;
        this.repeat = false;
        this.disableAlarm = false;
        this.isEnabled = false;
        this.isSounding = false;
        alarmTime = new Date();
        alarmTime.setHours(12);
        alarmTime.setMinutes(0);
        alarmTime.setSeconds(0);
        
    }
    
    
    
    /**
     * The alarm has been disabled and will not activate
     * 
     */
    public void disableAlarm(){
        this.disableAlarm = true;
        this.isEnabled = false;
        this.timer.cancel();
    }
    
    
    public void silenceAlarm(){
        this.isSounding = false;
        if(!this.repeat){
            this.timer.cancel();
        }
    }
    
    
    /**
     * The alarm has been snoozed and will sound again in 10 minutes. 
     * 
     */
    public void snoozeAlarm(){
        this.isSounding = false;
        Date tempTime = new Date();
        tempTime.setTime(alarmTime.getTime());
        snoozeTime.setMinutes(snoozeTime.getMinutes() + SNOOZE_TIME);
        alarmTime = snoozeTime;
        createOffset();
        alarmTime = tempTime;
        timer = new Timer();
                
            
    }

    public boolean isRepeat() {
        return repeat;
    }

    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

    public Date getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Date alarmTime) {
        this.alarmTime = alarmTime;
    }

    public boolean isDisableAlarm() {
        return disableAlarm;
    } 

    public Date getSnoozeTime() {
        return snoozeTime;
    }

    public void setSnoozeTime(Date snoozeTime) {
        this.snoozeTime = snoozeTime;
    }
    
    /**
     * activate is called when the designated alarm time has been reached and 
     * the alarm has not been disabled.
     */
    public void activate(){
        this.isSounding = true;
        if(!disableAlarm){

            if (repeat){
                alarmTime.setDate(alarmTime.getDate()+REPEAT_TIME);
                createOffset();
            }
            
             sysController.soundAlarm(this);
        }

    }
    
    public void enableAlarm(){
        this.isEnabled = true;
        generateAlarmTime(alarmTime.getHours(), alarmTime.getMinutes(), false, true);
        createOffset();
    }
    
    private void generateAlarmTime(int hours, int minutes, boolean AMTruePMFalse, boolean isMilitaryTime){
        if (isMilitaryTime){
            alarmTime.setHours(hours);
            alarmTime.setMinutes(minutes);
            
            if(alarmTime.before(new Date())){
                alarmTime.setDate(alarmTime.getDate() + 1);
            }
        }
        else{
                            
            if (AMTruePMFalse){
                alarmTime.setHours(hours);
                alarmTime.setMinutes(minutes);
                if(alarmTime.before(new Date())){
                    alarmTime.setDate(alarmTime.getDate() + 1);
                }
            }
            if(!AMTruePMFalse){
                alarmTime.setHours(hours + 12);
                alarmTime.setMinutes(minutes);
                if(alarmTime.before(new Date())){
                    alarmTime.setDate(alarmTime.getDate() + 1);
                }
            }
        }
        alarmTime.setSeconds(0);
    }
    
    public void updateAlarm(int hours, int minutes, boolean AMTruePMFalse, boolean isMilitaryTime){
        generateAlarmTime(hours, minutes, AMTruePMFalse, isMilitaryTime);
        this.timer.cancel();
        createOffset();
    }
    
    /**
     * an alarm is created to sound at a set number of hours and minutes
     * within the next 24 hours.
     */
    public void setAlarm(int hours, int minutes, boolean repeat, boolean AMTruePMFalse, boolean isMilitaryTime){
        this.repeat = repeat;
        alarmTime = new Date();
        this.disableAlarm = false;
        this.isEnabled = true;
        generateAlarmTime(hours, minutes, AMTruePMFalse, isMilitaryTime);

        snoozeTime = alarmTime;

        createOffset();

    }
    
    /**
     * the time until the alarm sounds is dictated through a Timer.
     */
    private void createOffset(){
        System.out.println(alarmTime.getHours());
        System.out.println(alarmTime.getMinutes());
        this.timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                Platform.runLater(() -> {
                    activate();
                    System.out.println("alarm activated");
                });
            }
        }, alarmTime);
    }
    
}
