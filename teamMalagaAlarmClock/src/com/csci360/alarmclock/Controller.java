/*
 * Assignment for CSCI 360, created by Team Malaga.
 */
package com.csci360.alarmclock;

import java.util.ArrayList;

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
    
    
    public Controller(){
        this.am_fm = new String[]{"AM", "FM"};
        this.soundingAlarm = null;
        this.alarm1 = new Alarm(this);
        this.alarm2 = new Alarm(this);
        this.currentMod = am_fm[1];
        this.radio = new Radio();
        this.volume = this.radio.getVolume();
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
        this.radio.playBroadcast();
    }
    
    public void radioOff(){
        this.radio.stop();
    }
    
    public void radioVolumeUp(){
        if (this.radio.getOn()){
            this.radio.incrementVolume();
            this.radio.playBroadcast();
            this.volume = this.radio.getVolume();
        }
    }
    
    public void radioVolumeDown(){
        if (this.radio.getOn()){
            this.radio.decrementVolume();
            this.radio.playBroadcast();
            this.volume = this.radio.getVolume();
        }
    }  
    
    //receiver and station control
    
    public void switchRadioReceiver(){
        if (this.radio.getOn()){
            this.radio.switchReceiver();
            this.currentMod = am_fm[(java.util.Arrays.asList(am_fm).indexOf(currentMod)+1)%2];
            this.radio.playBroadcast();
        }
    }
    
    public void incrementStation(){
        if (this.radio.getOn()){
            this.radio.nextStation();
            this.radio.playBroadcast();
        }
    }
    
    public void decrementStation(){
        if (this.radio.getOn()){
            this.radio.prevStation();
            this.radio.playBroadcast();
        }
    }
    
}

