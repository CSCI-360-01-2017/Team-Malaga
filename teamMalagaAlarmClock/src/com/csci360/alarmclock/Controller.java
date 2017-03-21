/*
 * Assignment for CSCI 360, created by Team Malaga.
 */
package com.csci360.alarmclock;

/**
 *
 * @author Team-Malaga
 */
public class Controller {
    
    private Alarm soundingAlarm;
    private Alarm alarm1;
    private Alarm alarm2;
    private Alarm selectedAlarm;
    private int hours;
    private int minutes;
    private boolean repeat;
    private String am_pm;
    private boolean isMilitaryTime;
    
    
    public Controller(){
        this.soundingAlarm = null;
        this.alarm1 = new Alarm(this);
        this.alarm2 = new Alarm(this);
        
}
    
    public void selectAlarm1(){
        this.selectedAlarm = this.alarm1;
    }
    
    public void selectAlarm2(){
        this.selectedAlarm = this.alarm2;
    }
    

    
    public void setHour(int h){
        this.hours = h;
    }
    
    
    public void setMinute(int m){
        this.minutes = m;
    }
    
    public void setRepeat(boolean r){
        this.repeat = r;
    }
    
    public void setAMPM(String ap){
        this.am_pm = ap;
    }
    
    public void setMilitaryTime(boolean mt){
        this.isMilitaryTime = mt;
    }
    
    public void setAlarm(){
        this.selectedAlarm.createAlarm(hours, minutes, repeat, am_pm, isMilitaryTime);
    }
    
    public void soundAlarm(Alarm a){
        this.soundingAlarm = a;
    }

    public void disableAlarm(){
        this.selectedAlarm.disableAlarm();
    }
    
    public void snoozeAlarm(){
        this.soundingAlarm.snoozeAlarm();
    }
    
}
