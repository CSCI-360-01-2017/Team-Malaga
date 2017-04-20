/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class FXMLController implements UITimingInterface {

    @FXML
    private Label currenttimetext;

    @FXML
    private RadioButton AMradio;

    @FXML
    private RadioButton ampm;

    @FXML
    private Button snoozebutton;

    @FXML
    private Button alarmVolUp;

    @FXML
    private Button alarmVolDown;

    @FXML
    private Button freqDown;

    @FXML
    private RadioButton a1enable;

    @FXML
    private Button volDown;

    @FXML
    private Label radiotext;

    @FXML
    private ToggleGroup hour;

    @FXML
    private ToggleGroup radioonoff;

    @FXML
    private Label alarm1text;

    @FXML
    private RadioButton a2repeat;

    @FXML
    private RadioButton FMradio;

    @FXML
    private ToggleGroup amfm;

    @FXML
    private RadioButton a1repeat;

    @FXML
    private ToggleButton radioon;

    @FXML
    private RadioButton a2enable;

    @FXML
    private Label alarm2text;

    @FXML
    private Button setAlarm1;

    @FXML
    private RadioButton twentyfour;

    @FXML
    private Button setAlarm2;

    @FXML
    private Button silencebutton;

    @FXML
    private ToggleButton radiooff;

    @FXML
    private Button freqUp;

    @FXML
    private Button volUp;
    
    @FXML
    private Button incHourA1;
    @FXML
    private Button decHourA1;
    @FXML
    private Button incHourA2;
    @FXML
    private Button decHourA2;
    @FXML
    private Button incMinA1;
    @FXML
    private Button decMinA1;
    @FXML
    private Button incMinA2;
    @FXML
    private Button decMinA2;
    @FXML
    private Button incMinA1Fast;
    @FXML
    private Button decMinA1Fast;
    @FXML
    private Button incMinA2Fast;
    @FXML
    private Button decMinA2Fast;
    
    @FXML
    private Label hourA1;
    @FXML
    private Label minA1;
    @FXML
    private Label hourA2;
    @FXML
    private Label minA2;
    
    @FXML
    private RadioButton am1;
    @FXML
    private RadioButton pm1;
    @FXML
    private RadioButton am2;
    @FXML
    private RadioButton pm2;
    
    private Controller controller;

    
    int alarm1Hour;
    int alarm2Hour;
    boolean alarm1isAM;
    int alarm1Min;
    int alarm2Min;
    boolean alarm2isAM;
    
    public FXMLController(){
       controller = new Controller(this);
       this.controller.setHourA1(12);
       this.controller.setMinuteA1(0);
       this.controller.setHourA2(12);
       this.controller.setMinuteA2(0);
       this.alarm1isAM = false;
       this.alarm2isAM = false;
    }
    
    
    @FXML
    public void incrementHourA1(ActionEvent event){
    this.controller.incrementHourA1();
        this.hourA1.setText(String.format("%02d", this.controller.getHourA1()));
    }
    
    @FXML
    public void decrementHourA1(ActionEvent event){
        this.controller.decrementHourA1();
        this.hourA1.setText(String.format("%02d", this.controller.getHourA1()));
    }
    
    @FXML
    public void incrementHourA2(ActionEvent event){
        this.controller.incrementHourA2();
        this.hourA2.setText(String.format("%02d", this.controller.getHourA2()));
    }
    
    @FXML
    public void decrementHourA2(ActionEvent event){
        this.controller.decrementHourA2();
        this.hourA2.setText(String.format("%02d", this.controller.getHourA2()));
    }
    @FXML
    public void incrementMinA1(ActionEvent event){
        this.controller.incrementMinA1();
        this.minA1.setText(String.format("%02d", this.controller.getMinuteA1()));
    }
    
    @FXML
    public void decrementMinA1(ActionEvent event){
        this.controller.decrementMinA1();
        this.minA1.setText(String.format("%02d", this.controller.getMinuteA1()));
    }
    
    @FXML
    public void incrementMinA2(ActionEvent event){
        this.controller.incrementMinA2();
        this.minA2.setText(String.format("%02d", this.controller.getMinuteA2()));
    }
    
    @FXML
    public void decrementMinA2(ActionEvent event){
        this.controller.decrementMinA2();
        this.minA2.setText(String.format("%02d", this.controller.getMinuteA2()));
    }
    @FXML
    public void incrementMinA1Fast(ActionEvent event){
        for(int i = 0; i < 10; i++){
            this.controller.incrementMinA1();
        }
        this.minA1.setText(String.format("%02d", this.controller.getMinuteA1()));
    }
    
    @FXML
    public void decrementMinA1Fast(ActionEvent event){
        for(int i = 0; i < 10; i++){
            this.controller.decrementMinA1();
        }
        this.minA1.setText(String.format("%02d", this.controller.getMinuteA1()));
    }
    
    @FXML
    public void incrementMinA2Fast(ActionEvent event){
        for(int i = 0; i < 10; i++){
            this.controller.incrementMinA2();
        }
        this.minA2.setText(String.format("%02d", this.controller.getMinuteA2()));
    }
    
    @FXML
    public void decrementMinA2Fast(ActionEvent event){
        for(int i = 0; i < 10; i++){
            this.controller.decrementMinA2();
        }
        this.minA2.setText(String.format("%02d", this.controller.getMinuteA2()));
    }
    
    @FXML
    public void setAlarm1(ActionEvent event){
        this.controller.setAlarm1();
        this.alarm1text.setText(String.format("%02d", this.alarm1Hour) + ":"+String.format("%02d", this.alarm1Min));
    }

    @FXML
    public void setAlarm2(ActionEvent event){
        this.controller.setAlarm2();
        this.alarm2text.setText(String.format("%02d", this.alarm2Hour) + ":"+String.format("%02d", this.alarm2Min));
    }
    
    
    @FXML
    public void freqUp(ActionEvent event){
        this.controller.incrementStation();
        this.radiotext.setText(this.controller.playBroadcast());
    }
    
    @FXML
    public void freqDown(ActionEvent event){
        this.controller.decrementStation();
        this.radiotext.setText(this.controller.playBroadcast());
    }
    
    @FXML
    public void switchReceiver(ActionEvent event){
        this.controller.switchRadioReceiver();
        this.radiotext.setText(this.controller.playBroadcast());
    }
    
    @FXML
    public void volUp(ActionEvent event){
        this.controller.radioVolumeUp();
        this.radiotext.setText(this.controller.playBroadcast());
    }
    
    @FXML
    public void volDown(ActionEvent event){
        this.controller.radioVolumeDown();
        this.radiotext.setText(this.controller.playBroadcast());
    }
    
    @FXML
    public void radioOn(ActionEvent event){
        this.controller.radioOn();
        this.radiotext.setMaxWidth(200);
        this.radiotext.setWrapText(true);
        this.radiotext.setText(this.controller.playBroadcast());
    }

    @FXML
    public void radioOff(ActionEvent event){
        this.controller.radioOff();
        this.radiotext.setText("");
    }
    
    @FXML
    public void toggleAMPM(ActionEvent event){
        this.controller.setMilitaryTime(false);
        this.controller.setHourA1(12);
        this.controller.setMinuteA1(0);
        this.controller.setHourA2(12);
        this.controller.setMinuteA2(0);
        this.hourA1.setText(String.format("%02d", this.controller.getHourA1()));
        this.minA1.setText(String.format("%02d", this.controller.getMinuteA1()));
        this.hourA2.setText(String.format("%02d", this.controller.getHourA2()));
        this.minA2.setText(String.format("%02d", this.controller.getMinuteA2()));
        this.am1.setDisable(false);
        this.pm1.setDisable(false);
        this.am2.setDisable(false);
        this.pm2.setDisable(false);
    }
    
    @FXML
    public void toggle24Hour(ActionEvent event){
        this.controller.setHourA1(12);
        this.controller.setMinuteA1(0);
        this.controller.setHourA2(12);
        this.controller.setMinuteA2(0);
        this.controller.setMilitaryTime(true);
        this.hourA1.setText(String.format("%02d", this.controller.getHourA1()));
        this.minA1.setText(String.format("%02d", this.controller.getMinuteA1()));
        this.hourA2.setText(String.format("%02d", this.controller.getHourA2()));
        this.minA2.setText(String.format("%02d", this.controller.getMinuteA2()));
        this.am1.setDisable(true);
        this.pm1.setDisable(true);
        this.am2.setDisable(true);
        this.pm2.setDisable(true);
    }

    public void updateMilitaryTime(int hours, int minutes) {
        this.currenttimetext.setText("   "+String.format("%02d", hours) + ":"+String.format("%02d", minutes));
    }


    public void updateAMPMTime(int hours, int minutes, boolean isAM) {
        if(isAM){
            this.currenttimetext.setText(String.format("%02d", hours) + ":"+String.format("%02d", minutes) + " AM");
        }
        else{
            this.currenttimetext.setText(String.format("%02d", hours) + ":"+String.format("%02d", minutes) + " PM");
        }
    }

}

