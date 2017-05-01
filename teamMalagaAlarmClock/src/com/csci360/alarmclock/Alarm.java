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
     * The alarm has been disabled and will not activate until it is enabled.
     */
    public void disableAlarm(){
        this.isSounding = false;
        this.isEnabled = false;
        this.timer.cancel();
    }
    
    /**
     * 
     * @return true if this alarm is enabled
     */
    public boolean getEnabled(){
        return this.isEnabled;
    }
    
    /**
     * 
     * @return the time for this alarm
     */
    public Date getAlarmTime(){
        return this.alarmTime;
    }

    /**
     * 
     * @return the time for this alarm
     */
    public Date getSnoozeTime(){
        return this.snoozeTime;
    }
    
    /**
     * The alarm has been silenced, it is no longer sounding but it will go off
     * in 1 day if it is set to repeat. If it is not set to repeat then the alarm
     * will be disabled.
     */
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
     * The alarm has been snoozed and will sound again in 10 minutes. 10 minutes will be added to snooze time
     * every time the alarm is snoozed. The alarmTime is used to set the timer, so
     * the alarm time is temporarily set to the snooze time and then changed back
     * to the original time.
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
    }
    
    /**
     * Returns if the alarm is currently sounding
     * @return isSounding Boolean
     */
    public boolean isSounding(){
        return this.isSounding;
    }
    
    /**
     * Returns if the alarm is set to repeat.
     * @return repeat boolean
     */
    public boolean isRepeat() {
        return repeat;
    }
    
    /**
     * Sets the alarm to repeat or not. If set to repeat, it will sound in 1 day
     * after it gets silenced.
     * @param repeat boolean
     */
    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }
    
    /**
     * activate is called when the designated alarm time has been reached and 
     * the alarm has not been disabled.
     */
    public void activate(){
        this.isSounding = true;
        sysController.soundAlarm(this);
    }
    
    
    /**
     * The alarm is set to enable. If it was previously enabled, that time gets 
     * canceled and the current time is set to go off. If it was not enabled then
     * it is now set to go off at the specified time.
     */
    public void enableAlarm(){
        if(this.isEnabled){
            this.timer.cancel();
        }
        this.isEnabled = true;
        generateAlarmTime(alarmTime.getHours(), alarmTime.getMinutes(), false, true);
        snoozeTime = alarmTime;
        createOffset();
    }
    
    
    /**
     * Sets the alarm time to a specified hours, minutes, am or pm, and 12 or 24 
     * hour time format. This is the time that the alarm will go off at if it gets
     * enabled.
     * @param hours int
     * @param minutes int
     * @param AMTruePMFalse boolean
     * @param isMilitaryTime boolean
     */
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
     * @param hours int
     * @param minutes int
     * @param AMTruePMFalse boolean
     * @param isMilitaryTime boolean
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
     * The time until the alarm sounds is dictated through a Timer. The alarmTime 
     * has been set using a previous method, if not it defaults to noon.
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
