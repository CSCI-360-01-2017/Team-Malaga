/*
 *  Assignment for CSCI 360, created by Team Malaga.
 *  This is a simple clock class that sends a signal to update the controller
 *  at a given clock update time which then gets sent further to the GUI.
 */
package com.csci360.alarmclock;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;
import javafx.application.Platform;

/**
 *
 * @author Team-Malaga
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
