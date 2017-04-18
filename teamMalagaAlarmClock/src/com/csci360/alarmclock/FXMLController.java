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
    private ToggleButton radioOn;

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
    private RadioButton a2enable;

    @FXML
    private TextArea alarm2text;

    @FXML
    private ToggleButton Alarm1Button;

    @FXML
    private ToggleButton Alarm2Button;

    @FXML
    private RadioButton twentyfour;

    @FXML
    private Button silencebutton;

    @FXML
    private Button freqUp;

    @FXML
    private Button volUp;

    public FXMLController(){
       Controller controller = new Controller();
    }

}

