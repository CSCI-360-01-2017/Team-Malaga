/*
 *  Assignment for CSCI 360, created by Team Malaga.
 */
package com.csci360.alarmclock;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Team-Malaga
 */
public class AlarmClockRadio extends Application {

    
    
     @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("alarmclockgui.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    
    /**
     * Force all platforms and threads of JavaFX to close
     */
    @Override
    public void stop()
    {
        Platform.exit();
        System.exit(0);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
