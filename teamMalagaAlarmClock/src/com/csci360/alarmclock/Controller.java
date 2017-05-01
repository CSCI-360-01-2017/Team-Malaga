/*
 * Assignment for CSCI 360, created by Team Malaga.
 * This class is the main controller for the project which holds two instances
 * of the alarm class along with a radio and the attributes needed to update these
 * classes from the GUI.
 */
package com.csci360.alarmclock;


import java.util.Calendar;

/**
 *
 * @author Team-Malaga
 */
public class Controller implements ControllerInterface{
    
    private Alarm alarm1;
    private Alarm alarm2;
    private int hoursA1;
    private int minutesA1;
    private int hoursA2;
    private int minutesA2;
    private boolean AMTruePMFalse;
    private boolean isMilitaryTime;
    private final Radio radio;
    private final String[] am_fm;
    private String currentMod;
    private int volume;
    private UITimingInterface ui;
    private Clock clk;
    private boolean isA1AM;
    private boolean isA2AM;
    
    public Controller(UITimingInterface uiInput){
        this.ui = uiInput;
        this.am_fm = new String[]{"AM", "FM"};
        this.alarm1 = new Alarm(this);
        this.alarm2 = new Alarm(this);
        this.currentMod = am_fm[1];
        this.radio = new Radio();
        this.volume = this.radio.getVolume();
        this.clk = new Clock(this);
        this.isA1AM = false;
        this.isA2AM = false;
        this.isMilitaryTime = false;
        
    }

    /**
     * The Controller class manages the incoming and outgoing function calls by the back-end of the AlarmClock system
     * to update internal changes, these changes can be noted by and linked up to GUI's with the proper layout and design
     * structure as the one implemented here in this project.
     * @Team Malaga
     */
    

    /**
     * This method is responsible for setting the hour in Alarm1
     * @param h 
     */
    public void setHourA1(int h){
        this.hoursA1 = h;
    }
    
    /**
     * This method is responsible for setting the minute in Alarm1
     */
    public void setMinuteA1(int m){
        this.minutesA1 = m;
    }
    
    /**
     *This method is responsible for setting the hour in Alarm2
     */
    public void setHourA2(int h){
        this.hoursA2 = h;
    }
    
    /**
     *This method is responsible for setting the minute in Alarm2
     */
    public void setMinuteA2(int m){
        this.minutesA2 = m;
    }
    
    /**
     *This method returns the hour of Alarm1
     * @return current Alarm1 hour
     */
    public int getHourA1(){
        return this.hoursA1;
    }
    
    /**
     *This method returns the minute of Alarm1
     * @return current Alarm1 minute
     */
    public int getMinuteA1(){
        return this.minutesA1;
    }
    
    /**
     *This method returns the hour of Alarm2
     * @return current Alarm2 hour
     */
    public int getHourA2(){
        return this.hoursA2;
    }
    
    /**
     *This method returns the minute of Alarm2
     * @return current Alarm2 minute
     */
    public int getMinuteA2(){
        return this.minutesA2;
    }
    
    /**
     *This method distinguishes whether the mode is set in military time or not and decrements the hour for Alarm1 by 1
     */
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
    
    /**
     *This method distinguishes whether the mode is set in military time or not and increments the hour for Alarm1 by 1
     */
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

    /**
     *This method determines that if the minutes in Alarm1 exceed 0, they should then be decremented by 1
     */
    public void decrementMinA1(){
        if(this.minutesA1>0){
            this.minutesA1--;
        }
    }
    
    /**
     *This method determines that if the minutes in Alarm1 do not exceed 58, they should then be incremented by 1
     */
    public void incrementMinA1(){
        if(this.minutesA1<59){
            this.minutesA1++;
        }
    }
    
    /**
     *This method distinguishes whether the mode is set in military time or not and decrements the hour for Alarm2 by 1
     */
    public void decrementHourA2(){
        if(this.isMilitaryTime){
            if(this.hoursA2>0){
                this.hoursA2--;
            }
        }else{
            if(this.hoursA2>1){
                this.hoursA2--;
            }
        }
    }
    
    /**
     *This method distinguishes whether the mode is set in military time or not and increments the hour for Alarm2 by 1
     */
    public void incrementHourA2(){
        if(this.isMilitaryTime){
            if(this.hoursA2<23){
                this.hoursA2++;
            }
        }else{
            if(this.hoursA2<12){
                this.hoursA2++;
            }
        }
    }

    /**
     *This method determines that if the minutes in Alarm2 exceed 0, they should then be decremented by 1
     */
    public void decrementMinA2(){
        if(this.minutesA2>0){
            this.minutesA2--;
        }
    }
    
    /**
     *This method determines that if the minutes in Alarm2 do not exceed 58, they should then be incremented by 1
     */
    public void incrementMinA2(){
        if(this.minutesA2<59){
            this.minutesA2++;
        }
    }
    
    /**
     *This method makes the Alarm object for alarm1 enabled
     */
    public void enableA1(){
        this.alarm1.enableAlarm();
    }
    
    /**
     *This method makes the Alarm object for alarm2 enabled
     */
    public void enableA2(){
        this.alarm2.enableAlarm();
    }
    
    /**
     *This method makes it so that Alarm1 will repeat in 24 hours
     */
    public void setRepeatA1(boolean repeat){
        this.alarm1.setRepeat(repeat);
    }
    
    /**
     *This method makes it so that Alarm2 will repeat in 24 hours
     */
    public void setRepeatA2(boolean repeat){
        this.alarm2.setRepeat(repeat);
    }
    
    /**
     * This method returns whether or not alarm1 is set to repeat in 24 hours
     * @return alarm1 object repeat boolean
     */
    public boolean getRepeatA1(){
        return this.alarm1.isRepeat();
    }
    
    /**
     * This method returns whether or not alarm2 is set to repeat in 24 hours
     * @return alarm2 object repeat boolean
     */
    public boolean getRepeatA2(){
        return this.alarm2.isRepeat();
    }

    /**
     *This method makes Alarm1 disabled, in which case it will not sound the alarm when the alarm time is reached
     */
    public void disableA1(){
        this.alarm1.disableAlarm();
    }
    
    /**
     *This method makes Alarm2 disabled, in which case it will not sound the alarm when the alarm time is reached
     */
    public void disableA2(){
        this.alarm2.disableAlarm();
    }
        
    /**
     *This method sets whether or not AMPM is on or off for the Clock
     */
    public void setAMPM(boolean ap){
        this.AMTruePMFalse = ap;
    }
    
    /**
     *This method sets whether or not AMPM is on or off for the Alarm1
     */
    public void setA1AM(boolean A1AM){
        this.isA1AM = A1AM;
    }
    
    /**
     *This method sets whether or not AMPM is on or off for the Alarm2
     */
    public void setA2AM(boolean A2AM){
        this.isA2AM = A2AM;
    }
    
    /**
     *This method returns whether or not the AMPM functionality for Alarm 1 is engaged
     * @return boolean of alarm1 AMPM is engaged
     */
    public boolean isA1AM(){
        return this.isA1AM;
    }
    
    /**
     *This method returns whether or not the AMPM functionality for Alarm 2 is engaged
     * @return boolean of alarm2 AMPM is engaged
     */
    public boolean isA2AM(){
        return this.isA2AM;
    }
    
    /**
     * This method checks whether military time is enabled
     * if it is, then both the hours for alarm1 and alarm2 will be incremented by twelve
     * if it is not, then both the hours for alarm1 and alarm2 will be decremented by twelve
    */
    public void setMilitaryTime(boolean mt){
        if(mt){ //set it to military time, need to add 12 if currently in PM
            if(!this.isA1AM && this.hoursA1 != 12){  //if pm add 12
                this.hoursA1 += 12;
            }
            else if(this.isA1AM && this.hoursA1 == 12){ // if am and 12, aka midnight, subtract 12
                this.hoursA1 -=12;
            }
            if(!this.isA2AM && this.hoursA2 != 12){  //if pm add 12
                this.hoursA2 += 12;
            }
            else if(this.isA2AM && this.hoursA2 == 12){ // if am and 12, aka midnight, subtract 12
                this.hoursA2 -=12;
            }
        }
        else{ //set it to AM/PM, need to subtract 12 if hours > 12
            if(this.hoursA1 > 12){
                this.hoursA1 -= 12;
                this.isA1AM = false;
            }
            if(this.hoursA2 > 12){
                this.hoursA2 -= 12;
                this.isA2AM = false;
            }
            
        }
        this.isMilitaryTime = mt;
    }
    
    /**
     *This method is used to return whether or not the time is set in military time or not
     * @return whether military time is engaged or not
     */
    public boolean isMilitaryTime(){
        return this.isMilitaryTime;
    }
    
    /**
     *This method makes a new alarm object for alarm 1 with all of these stored global values for its creation
     */
    public void setAlarm1(){
        this.alarm1.setAlarm(hoursA1, minutesA1, AMTruePMFalse, isMilitaryTime);
    }
    
    /**
     *This method makes a new alarm object for alarm 2 with all of these stored global values for its creation
     */
    public void setAlarm2(){
        this.alarm2.setAlarm(hoursA2, minutesA2, AMTruePMFalse, isMilitaryTime);
    }
    
    /**
     *This method determines which alarm is being passed in and sends the global sounding variable of the respective alarm to on 
     */
    @Override
    public void soundAlarm(Alarm a){
        if(a == this.alarm1){
            this.ui.soundAlarm(1);
        }
        else{
            this.ui.soundAlarm(2);
        }
    }
    
    
    public boolean isSoundingA1(){
        return this.alarm1.isSounding();
    }
    
    public boolean isSoundingA2(){
        return this.alarm2.isSounding();
    }

    /**
     *This method disables the respective sounding alarm (1 or 2) for 24 hours
     */
    public void silenceAlarm(){
        if(this.alarm1.isSounding()){
            this.alarm1.silenceAlarm();
        }
        if(this.alarm2.isSounding()){
            this.alarm2.silenceAlarm();
        }
    }
    
    /**
     *This method disables the respective sounding alarm (1 or 2) by appending 10 minutes to the sounding of the next alarm
     */
    public void snoozeAlarm(){
        if(this.alarm1.isSounding()){
            this.alarm1.snoozeAlarm();
        }
        if(this.alarm2.isSounding()){
            this.alarm2.snoozeAlarm();
        }
    }
    
    
    //radio methods
    
    /**
     * Responsible for turning on the radio object
     */
    public void radioOn(){
        this.radio.start();
    }
    
    /**
     * Responsible for turning off the radio object
     */
    public void radioOff(){
        this.radio.stop();
    }
    
    /**
     * Responsible for incrementing the volume and updating the global variable
     */
    public void radioVolumeUp(){
        if (this.radio.getOn()){
            this.radio.incrementVolume();
            this.volume = this.radio.getVolume();
        }
    }
    
    /**
     * Responsible for decrementing the volume and updating the global variable
     */
    public void radioVolumeDown(){
        if (this.radio.getOn()){
            this.radio.decrementVolume();
            this.volume = this.radio.getVolume();
        }
    }  
    
    //receiver and station control
    
    /**
     * Method used to switch between arrays of stored AM or FM frequencies
     */
    public void switchRadioReceiver(){
        this.radio.switchReceiver();
        this.currentMod = am_fm[(java.util.Arrays.asList(am_fm).indexOf(currentMod)+1)%2];
    }
    
    /**
     *This method traverses to the next available station in the radio object
     */
    public void incrementStation(){
        if (this.radio.getOn()){
            this.radio.nextStation();
        }
    }
    
    /**
     *This method traverses to the previous available station in the radio object
     */
    public void decrementStation(){
        if (this.radio.getOn()){
            this.radio.prevStation();
        }
    }
    
    /**
     *This method returns the string of the current station broadcast index in the radio object
     * @return returns string of text which is stored in AM or FM array
     */
    public String playBroadcast(){
        if (this.radio.getOn()){
            return this.radio.playBroadcast();
        }
        else{
            return "";
        }
    }

    
    /**
     *This method is responsible for the ui updating of the textfields with reference to AMPM or military time specification
     */
    @Override
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

