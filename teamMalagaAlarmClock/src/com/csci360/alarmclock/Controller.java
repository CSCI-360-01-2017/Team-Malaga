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
    private int hoursA1;
    private int minutesA1;
    private int hoursA2;
    private int minutesA2;
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
    
    
    
    public void setHourA1(int h){
        this.hoursA1 = h;
    }
    
    public void setMinuteA1(int m){
        this.minutesA1 = m;
    }
    public void setHourA2(int h){
        this.hoursA2 = h;
    }
    
    public void setMinuteA2(int m){
        this.minutesA2 = m;
    }
    public int getHourA1(){
        return this.hoursA1;
    }
    
    public int getMinuteA1(){
        return this.minutesA1;
    }
    public int getHourA2(){
        return this.hoursA2;
    }
    
    public int getMinuteA2(){
        return this.minutesA2;
    }
    
    public void decrementHourA1(){
        if(this.isMilitaryTime){
            if(this.hoursA1>0){
                this.hoursA1--;
            }
        }
        else{
            if(this.hoursA1>1){
                this.hoursA1--;
            }
        }
    }
    
    public void incrementHourA1(){
        if(this.isMilitaryTime){
            if(this.hoursA1<23){
                this.hoursA1++;
            }
        }
        else{
            if(this.hoursA1<12){
                this.hoursA1++;
            }
        }
    }

    public void decrementMinA1(){
        if(this.minutesA1>0){
            this.minutesA1--;
        }
    }
    
    public void incrementMinA1(){
        if(this.minutesA1<59){
            this.minutesA1++;
        }
    }
    public void decrementHourA2(){
        if(this.isMilitaryTime){
            if(this.hoursA2>0){
                this.hoursA2--;
            }
        }
        else{
            if(this.hoursA2>1){
                this.hoursA2--;
            }
        }
    }
    
    public void incrementHourA2(){
        if(this.isMilitaryTime){
            if(this.hoursA2<23){
                this.hoursA2++;
            }
        }
        else{
            if(this.hoursA2<12){
                this.hoursA2++;
            }
        }
    }

    public void decrementMinA2(){
        if(this.minutesA2>0){
            this.minutesA2--;
        }
    }
    
    public void incrementMinA2(){
        if(this.minutesA2<59){
            this.minutesA2++;
        }
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
    
    public void setAlarm1(){
        this.alarm1.createAlarm(hoursA1, minutesA1, repeat, AMTruePMFalse, isMilitaryTime);
    }
    
    public void setAlarm2(){
        this.alarm2.createAlarm(hoursA2, minutesA2, repeat, AMTruePMFalse, isMilitaryTime);
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

