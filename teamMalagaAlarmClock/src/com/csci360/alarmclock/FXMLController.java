/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class FXMLController {

    @FXML
    private TextArea currenttimetext;

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
    private TextArea radiotext;

    @FXML
    private ToggleGroup hour;

    @FXML
    private ToggleGroup radioonoff;

    @FXML
    private TextArea alarm1text;

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
    private TextArea alarm2text;

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
    
    private Controller controller;

    public FXMLController(){
       controller = new Controller();
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
        this.radiotext.setText(this.controller.playBroadcast());
    }

    @FXML
    public void radioOff(ActionEvent event){
        this.controller.radioOff();
        this.radiotext.setText("");
    }
}

