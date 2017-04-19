/*
 * Assignment for CSCI 360, created by Team Malaga.
 */
package com.csci360.alarmclock;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Team-Malaga
 */
public class Controller implements ControllerInterface{
    
    private Alarm soundingAlarm;
    private Alarm alarm1;
    private Alarm alarm2;
    private Alarm selectedAlarm;
    private int hours;
    private int minutes;
    private boolean repeat;
    private boolean AMTruePMFalse;
    private boolean isMilitaryTime;
    private final Radio radio;
    private final String[] am_fm;
    private String currentMod;
    private int volume;
    private UITimingInterface ui;
    private Clock clk;
    
    public Controller(UITimingInterface uiInput){
        this.ui = uiInput;
        this.am_fm = new String[]{"AM", "FM"};
        this.soundingAlarm = null;
        this.alarm1 = new Alarm(this);
        this.alarm2 = new Alarm(this);
        this.currentMod = am_fm[1];
        this.radio = new Radio();
        this.volume = this.radio.getVolume();
        this.clk = new Clock(this);
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
    
    public void setAMPM(boolean ap){
        this.AMTruePMFalse = ap;
    }
    
    public void setMilitaryTime(boolean mt){
        this.isMilitaryTime = mt;
    }
    
    public void setAlarm(){
        this.selectedAlarm.createAlarm(hours, minutes, repeat, AMTruePMFalse, isMilitaryTime);
    }
    
    public void soundAlarm(Alarm a){
        this.soundingAlarm = a;
    }
    
    public Alarm getSoundingAlarm(){
        return this.soundingAlarm;
    }

    public void disableAlarm(){
        this.selectedAlarm.disableAlarm();
    }
    
    public void snoozeAlarm(){
        this.soundingAlarm.snoozeAlarm();
    }
    
    
    //radio methods
    
    //on off and volume control
    public void radioOn(){
        this.radio.start();
    }
    
    public void radioOff(){
        this.radio.stop();
    }
    
    public void radioVolumeUp(){
        if (this.radio.getOn()){
            this.radio.incrementVolume();
            this.volume = this.radio.getVolume();
        }
    }
    
    public void radioVolumeDown(){
        if (this.radio.getOn()){
            this.radio.decrementVolume();
            this.volume = this.radio.getVolume();
        }
    }  
    
    //receiver and station control
    
    public void switchRadioReceiver(){
        this.radio.switchReceiver();
        this.currentMod = am_fm[(java.util.Arrays.asList(am_fm).indexOf(currentMod)+1)%2];
    }
    
    public void incrementStation(){
        if (this.radio.getOn()){
            this.radio.nextStation();
        }
    }
    
    public void decrementStation(){
        if (this.radio.getOn()){
            this.radio.prevStation();
        }
    }
 
    public String playBroadcast(){
        if (this.radio.getOn()){
            return this.radio.playBroadcast();
        }
        else{
            return "";
        }
    }

    public void updateTime(Calendar cal) {
        if(isMilitaryTime){
            this.ui.updateMilitaryTime(cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));
        } else{
            if(cal.get(Calendar.AM_PM) == Calendar.AM){
                this.ui.updateAMPMTime(cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), true);
                setAMPM(true);
            }else{
                this.ui.updateAMPMTime(cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), false);
                setAMPM(false);
            }
            
        }
        
    }
}

