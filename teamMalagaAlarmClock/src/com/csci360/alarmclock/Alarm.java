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
    private Date snoozeTime;
    private Timer timer;
    
    /**
     *
     *  Constructor for Alarm, it needs an instance of a controller to which
     *  it can send the sound alarm signal. Default time for the alarms is set to noon.
     * @param c ControllerInterface to send the sound alarm notification back to
     */
    public Alarm(ControllerInterface c) {
        this.sysController = c;
        this.repeat = false;
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
        this.isSounding = false;
        this.isEnabled = false;
        this.timer.cancel();
    }
    
    
    public void silenceAlarm(){
        this.isSounding = false;
        if(!this.repeat){
            this.isEnabled = false;
            this.timer.cancel();
        }
        else{
            this.timer.cancel();
            enableAlarm();
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
    //    timer = new Timer();    
    }
    
    public boolean isSounding(){
        return this.isSounding;
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
    
    /**
     * activate is called when the designated alarm time has been reached and 
     * the alarm has not been disabled.
     */
    public void activate(){
        this.isSounding = true;
        sysController.soundAlarm(this);
    }
    
    public void enableAlarm(){
        if(this.isEnabled){
            this.timer.cancel();
        }
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
    
    
    /**
     * an alarm is created to sound at a set number of hours and minutes
     * within the next 24 hours.
     */
    public void setAlarm(int hours, int minutes, boolean AMTruePMFalse, boolean isMilitaryTime){
        
        if(this.isEnabled){
            this.timer.cancel();
        }

        alarmTime = new Date();
        this.isEnabled = true;
        generateAlarmTime(hours, minutes, AMTruePMFalse, isMilitaryTime);

        snoozeTime = alarmTime;

        createOffset();

    }
    
    /**
     * the time until the alarm sounds is dictated through a Timer.
     */
    private void createOffset(){
        this.timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                Platform.runLater(() -> {
                    activate();
                });
            }
        }, alarmTime);
    }
    
}
