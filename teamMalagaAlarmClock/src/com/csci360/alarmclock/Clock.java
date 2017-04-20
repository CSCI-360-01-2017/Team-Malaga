/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;
import javafx.application.Platform;

/**
 *
 * @author Eric
 */
public class Clock {
    private ControllerInterface sysController;
    static final int CLOCK_UPDATE_TIME = 500;
    
    public Clock(ControllerInterface c){
        this.sysController = c;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                Platform.runLater(() -> {
                    sysController.updateTime(Calendar.getInstance());
                });

            }
        }, 0, CLOCK_UPDATE_TIME);
    }
    
    
}
