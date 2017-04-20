package com.csci360.alarmclock;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Image;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.scene.paint.Color;


/**
 *
 * @author bryce
 */
public class GUI extends Application implements EventHandler<ActionEvent>, UITimingInterface{
    //primaryStage.setMaximized(true);
    //primaryStage.setFullScreen(true);
    Radio radio = new Radio();
    Controller controller = new Controller(this);
    
    Screen screen = Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();
    Button silenceButton;
    Button snoozeButton;
    ToggleButton alarm1Button;
    ToggleButton alarm2Button;
    Button modeButton;
    Button alarm1DisableButton;
    Button alarm2DisableButton;
    Button repeatButton;
    Button ampmToggleButton;
    Button amfmToggleButton;
    Button radioButton;
    Button alarmVolumeIncrementButton;
    Button alarmVolumeDecrementButton;
    Button radioVolumeIncrementButton;
    Button radioVolumeDecrementButton;
    Button radioFrequencyIncrementButton;
    Button radioFrequencyDecrementButton;
    Button hourIncrementButton;
    Button hourDecrementButton;
    Button minuteIncrementButton;
    Button minuteDecrementButton;
    
    boolean twentyfourbool;
    boolean visibility = true;
    boolean onbool = radio.getOn();
    boolean alarm1repeatbool;
    boolean alarm1enabledbool = true;
    boolean alarm2repeatbool = true;
    boolean alarm2enabledbool = true;
    boolean AMbool = true;
    boolean FMbool = !AMbool;
    @Override
    public void start(Stage primaryStage) {
        
        int midbuttonheight = 70;
        int midbuttonwidth = 30;
        int arrowbuttonheight = 30;
        int arrowbuttonwidth = 40;
        int bigbuttonheight = 65;
        int bigbuttonwidth = 190;
        
        boolean visibility = true;
        boolean onbool = false;
        boolean alarm1repeatbool = true;
        boolean alarm1enabledbool = true;
        boolean alarm2repeatbool = true;
        boolean alarm2enabledbool = true;
        boolean AMbool = true;
        boolean FMbool = !AMbool;
        //boolean twentyfourbool = true;
        
        primaryStage.setTitle("AlarmClock");
        Text radioText = new Text(692,370, "ON");
        radioText.setStyle("-fx-font: 12 arial;");
        
        Text alarm1Text = new Text(177,129,"DISABLE");
        alarm1Text.setStyle("-fx-font: 9 arial;");
        
        Text alarm2Text = new Text(177, 197, "DISABLE");
        alarm2Text.setStyle("-fx-font: 9 arial;");
        
        Text hourText = new Text(245,175, "Hour");
        hourText.setStyle("-fx-font: 14 arial;");
        
        Text minuteText = new Text(295,175, "Minute");
        minuteText.setStyle("-fx-font: 14 arial;");
        
        Text frequencyText = new Text(295,360, "Frequency");
        frequencyText.setStyle("-fx-font: 14 arial;");
        
        Text alarmVolumeText = new Text(475,175, "Alarm Volume");
        alarmVolumeText.setStyle("-fx-font: 14 arial;");
        
        Text radioVolumeText = new Text(407,362, "Volume");
        radioVolumeText.setStyle("-fx-font: 14 arial;");
        
        Text alarm1RepeatText = new Text(102,155, "Repeat");
        alarm1RepeatText.setStyle("-fx-font: 13 arial;");
        
        Text alarm1EnabledText = new Text(102,170, "Enabled");
        alarm1EnabledText.setStyle("-fx-font: 13 arial;");
        
        Text alarm2RepeatText = new Text(102,222, "Repeat");
        alarm2RepeatText.setStyle("-fx-font: 12 arial;");
        
        Text alarm2EnabledText = new Text(102,237, "Enabled");
        alarm2EnabledText.setStyle("-fx-font: 12 arial;");
        
        Text twentyfourText = new Text(125,52, "24 hour");
        twentyfourText.setStyle("-fx-font: 12 arial;");
        
        
        
        Line beginning = new Line(0,281,411, 281);
        Line middle = new Line(411,281,411, 241);
        Line end = new Line(411,241,820, 241);
        
        
        
        Circle onCircle = new Circle(680, 365, 6, Color.GREEN); 
        onCircle.setVisible(onbool);
        
        Circle alarm1RepeatCircle = new Circle(90, 150, 6, Color.GREEN);
        alarm1RepeatCircle.setVisible(this.alarm1repeatbool);
        
        Circle alarm1EnabledCircle = new Circle(90, 165, 6, Color.GREEN);
        alarm1EnabledCircle.setVisible(this.alarm1enabledbool);
        
        Circle alarm2RepeatCircle = new Circle(90, 217, 6, Color.GREEN);
        alarm2RepeatCircle.setVisible(this.alarm2repeatbool);
        
        Circle alarm2EnabledCircle = new Circle(90, 232, 6, Color.GREEN);
        alarm2EnabledCircle.setVisible(this.alarm2enabledbool);
        
        Circle twentyfourCircle = new Circle(113, 48, 6, Color.GREEN);
        twentyfourCircle.setVisible(this.twentyfourbool);
        
        
        
        
        silenceButton = new Button();
        silenceButton.setText("SILENCE");
        silenceButton.setOnAction(this);
        silenceButton.setStyle("-fx-font: 36 arial;");
        silenceButton.setMinWidth(bigbuttonwidth);
        silenceButton.setMinHeight(bigbuttonheight);
        silenceButton.setTranslateX(590);
        silenceButton.setTranslateY(104);
        silenceButton.setVisible(visibility);
        
        snoozeButton = new Button();
        snoozeButton.setText("SNOOZE");
        snoozeButton.setOnAction(this);
        snoozeButton.setStyle("-fx-font: 36 arial;");
        snoozeButton.setMinWidth(bigbuttonwidth);
        snoozeButton.setMinHeight(bigbuttonheight);
        snoozeButton.setTranslateX(590);
        snoozeButton.setTranslateY(16);
        snoozeButton.setVisible(visibility);

        modeButton = new Button();
        modeButton.setText("Mode");
        modeButton.setOnAction(this);
        modeButton.setMinWidth(70);
        modeButton.setMinHeight(30);
        modeButton.setTranslateX(30);
        modeButton.setTranslateY(31);
        modeButton.setVisible(visibility);
        modeButton.setStyle("-fx-font: 14 arial;");

        
        
        alarm1Button = new ToggleButton();
        alarm1Button.setText("Alarm 1");
        alarm1Button.setOnAction(this);
        alarm1Button.setMinWidth(70);
        alarm1Button.setMinHeight(30);
        alarm1Button.setTranslateX(90);
        alarm1Button.setTranslateY(110);
        alarm1Button.setVisible(visibility);
        
        alarm2Button = new ToggleButton();
        alarm2Button.setText("Alarm 2");
        alarm2Button.setOnAction(this);
        alarm2Button.setMinWidth(70);
        alarm2Button.setMinHeight(30);
        alarm2Button.setTranslateX(90);
        alarm2Button.setTranslateY(177);
        alarm2Button.setVisible(visibility);
        
        alarm1DisableButton = new Button();
        alarm1DisableButton.setText("DISABLE");
        alarm1DisableButton.setOnAction(this);
        alarm1DisableButton.setStyle("-fx-font: 9 arial;");
        alarm1DisableButton.setMinWidth(56);
        alarm1DisableButton.setMinHeight(19);
        alarm1DisableButton.setTranslateX(167);
        alarm1DisableButton.setTranslateY(113);
        alarm1DisableButton.setVisible(visibility);
        
        
        alarm2DisableButton = new Button();
        alarm2DisableButton.setText("DISABLE");
        alarm2DisableButton.setOnAction(this);
        alarm2DisableButton.setStyle("-fx-font: 9 arial;");
        alarm2DisableButton.setMinWidth(56);
        alarm2DisableButton.setMinHeight(19);
        alarm2DisableButton.setTranslateX(167);
        alarm2DisableButton.setTranslateY(180);
        alarm2DisableButton.setVisible(visibility);
        
        
        hourIncrementButton = new Button();
        hourIncrementButton.setText("+");
        hourIncrementButton.setOnAction(this);
        hourIncrementButton.setMinWidth(40);
        hourIncrementButton.setMinHeight(30);
        hourIncrementButton.setTranslateX(240);
        hourIncrementButton.setTranslateY(126);
        hourIncrementButton.setVisible(visibility);
        
        hourDecrementButton = new Button();
        hourDecrementButton.setText("-");
        hourDecrementButton.setOnAction(this);
        hourDecrementButton.setMinWidth(40);
        hourDecrementButton.setMinHeight(30);
        hourDecrementButton.setTranslateX(240);
        hourDecrementButton.setTranslateY(185);
        hourDecrementButton.setVisible(visibility);
        
        minuteIncrementButton = new Button();
        minuteIncrementButton.setText("+");
        minuteIncrementButton.setOnAction(this);
        minuteIncrementButton.setMinWidth(40);
        minuteIncrementButton.setMinHeight(30);
        minuteIncrementButton.setTranslateX(300);
        minuteIncrementButton.setTranslateY(126);
        minuteIncrementButton.setVisible(visibility);
        
        minuteDecrementButton = new Button();
        minuteDecrementButton.setText("-");
        minuteDecrementButton.setOnAction(this);
        minuteDecrementButton.setMinWidth(40);
        minuteDecrementButton.setMinHeight(30);
        minuteDecrementButton.setTranslateX(300);
        minuteDecrementButton.setTranslateY(185);
        minuteDecrementButton.setVisible(visibility);
        
        alarmVolumeIncrementButton = new Button();
        alarmVolumeIncrementButton.setText("+");
        alarmVolumeIncrementButton.setOnAction(this);
        alarmVolumeIncrementButton.setMinWidth(arrowbuttonwidth);
        alarmVolumeIncrementButton.setMinHeight(arrowbuttonheight);
        alarmVolumeIncrementButton.setTranslateX(500);
        alarmVolumeIncrementButton.setTranslateY(125);
        alarmVolumeIncrementButton.setVisible(visibility);
        
        alarmVolumeDecrementButton = new Button();
        alarmVolumeDecrementButton.setText("-");
        alarmVolumeDecrementButton.setOnAction(this);
        alarmVolumeDecrementButton.setMinWidth(arrowbuttonwidth);
        alarmVolumeDecrementButton.setMinHeight(arrowbuttonheight);
        alarmVolumeDecrementButton.setTranslateX(500);
        alarmVolumeDecrementButton.setTranslateY(184);
        alarmVolumeDecrementButton.setVisible(visibility);
        
        radioFrequencyIncrementButton = new Button();
        radioFrequencyIncrementButton.setText("+");
        radioFrequencyIncrementButton.setOnAction(this);
        radioFrequencyIncrementButton.setMinWidth(arrowbuttonwidth);
        radioFrequencyIncrementButton.setMinHeight(arrowbuttonheight);
        radioFrequencyIncrementButton.setTranslateX(310);
        radioFrequencyIncrementButton.setTranslateY(312);
        radioFrequencyIncrementButton.setVisible(visibility);
        
        radioFrequencyDecrementButton = new Button();
        radioFrequencyDecrementButton.setText("-");
        radioFrequencyDecrementButton.setOnAction(this);
        radioFrequencyDecrementButton.setMinWidth(arrowbuttonwidth);
        radioFrequencyDecrementButton.setMinHeight(arrowbuttonheight);
        radioFrequencyDecrementButton.setTranslateX(310);
        radioFrequencyDecrementButton.setTranslateY(371);
        radioFrequencyDecrementButton.setVisible(visibility);
        
        radioVolumeIncrementButton = new Button();
        radioVolumeIncrementButton.setText("+");
        radioVolumeIncrementButton.setOnAction(this);
        radioVolumeIncrementButton.setMinWidth(arrowbuttonwidth);
        radioVolumeIncrementButton.setMinHeight(arrowbuttonheight);
        radioVolumeIncrementButton.setTranslateX(415);
        radioVolumeIncrementButton.setTranslateY(312);
        radioVolumeIncrementButton.setVisible(visibility);
        
        radioVolumeDecrementButton = new Button();
        radioVolumeDecrementButton.setText("-");
        radioVolumeDecrementButton.setOnAction(this);
        radioVolumeDecrementButton.setMinWidth(arrowbuttonwidth);
        radioVolumeDecrementButton.setMinHeight(arrowbuttonheight);
        radioVolumeDecrementButton.setTranslateX(415);
        radioVolumeDecrementButton.setTranslateY(371);
        radioVolumeDecrementButton.setVisible(visibility);
        
        repeatButton = new Button();
        repeatButton.setText("Repeat");
        repeatButton.setOnAction(this);
        repeatButton.setMinWidth(80);
        repeatButton.setMinHeight(30);
        repeatButton.setTranslateX(370);
        repeatButton.setTranslateY(155);
        repeatButton.setVisible(visibility);
        
        amfmToggleButton = new Button();
        amfmToggleButton.setText("AM/FM");
        amfmToggleButton.setOnAction(this);
        amfmToggleButton.setMinWidth(80);
        amfmToggleButton.setMinHeight(30);
        amfmToggleButton.setTranslateX(510);
        amfmToggleButton.setTranslateY(341);
        amfmToggleButton.setVisible(visibility);
        
        ampmToggleButton = new Button();
        ampmToggleButton.setText("AM/PM");
        ampmToggleButton.setOnAction(this);
        ampmToggleButton.setMinWidth(80);
        ampmToggleButton.setMinHeight(30);
        ampmToggleButton.setTranslateX(250);
        ampmToggleButton.setTranslateY(227);
        ampmToggleButton.setVisible(visibility);
        
        radioButton = new Button();
        radioButton.setText("Radio");
        radioButton.setOnAction(this);
        radioButton.setStyle("-fx-font: 36 arial;");
        radioButton.setMinWidth(140);
        radioButton.setMinHeight(59);
        radioButton.setTranslateX(620);
        radioButton.setTranslateY(268);
        radioButton.setVisible(visibility);
        
        //Label timeLabel = new Label();


        
        Pane layout = new Pane();
      
        
        layout.getChildren().add(radioText);
        layout.getChildren().add(modeButton);
        layout.getChildren().add(silenceButton);
        layout.getChildren().add(snoozeButton);
        layout.getChildren().add(alarm1Button);
        layout.getChildren().add(alarm2Button);
        layout.getChildren().add(alarm1DisableButton);
        layout.getChildren().add(alarm2DisableButton);
        layout.getChildren().add(hourIncrementButton);
        layout.getChildren().add(hourText);
        layout.getChildren().add(hourDecrementButton);
        layout.getChildren().add(minuteIncrementButton);
        layout.getChildren().add(minuteDecrementButton);
        layout.getChildren().add(minuteText);
        layout.getChildren().add(radioVolumeDecrementButton);
        layout.getChildren().add(radioVolumeText);
        layout.getChildren().add(radioVolumeIncrementButton);
        layout.getChildren().add(radioFrequencyIncrementButton);
        layout.getChildren().add(frequencyText);
        layout.getChildren().add(radioFrequencyDecrementButton);
        layout.getChildren().add(alarmVolumeIncrementButton);
        layout.getChildren().add(alarmVolumeText);
        layout.getChildren().add(alarmVolumeDecrementButton);
        layout.getChildren().add(repeatButton);
        layout.getChildren().add(amfmToggleButton);
        layout.getChildren().add(ampmToggleButton);
        layout.getChildren().add(radioButton);
        layout.getChildren().add(beginning);
        layout.getChildren().add(middle);
        layout.getChildren().add(end);
        layout.getChildren().add(onCircle);
        layout.getChildren().add(alarm1RepeatText);
        layout.getChildren().add(alarm1EnabledText);
        layout.getChildren().add(alarm2RepeatText);
        layout.getChildren().add(alarm2EnabledText);
        layout.getChildren().add(alarm1RepeatCircle);
        layout.getChildren().add(alarm1EnabledCircle);
        layout.getChildren().add(alarm2EnabledCircle);
        layout.getChildren().add(alarm2RepeatCircle);
        layout.getChildren().add(twentyfourCircle);
        layout.getChildren().add(twentyfourText);
        
        Scene scene = new Scene(layout, 820, 440);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @Override
    public void handle(ActionEvent event){
        if(event.getSource() == silenceButton){
            controller.disableAlarm();
        }
        if(event.getSource() == snoozeButton){
            controller.snoozeAlarm();
        }
        if(event.getSource() == modeButton){
            twentyfourbool = !this.twentyfourbool;
            if(twentyfourbool == true){
                controller.setAMPM(true);
                controller.setMilitaryTime(false);
            } else {
                controller.setAMPM(false);
                controller.setMilitaryTime(true);
            }
            System.out.println(twentyfourbool);
           // layout.requestLayout();
            
        }
        if(event.getSource() == alarm1Button){
            this.alarm2Button.disarm();
        }
        if(event.getSource() == alarm2Button){
            this.alarm1Button.disarm();
        }
        if(event.getSource() == alarmVolumeIncrementButton){
            
        }
        if(event.getSource() == alarmVolumeDecrementButton){
            controller.decrementStation();
        }
        if(event.getSource() == alarm1DisableButton){
            
        }
        if(event.getSource() == alarm2DisableButton){
            
        }
        
        if(event.getSource() == hourIncrementButton){
            
        }
        if(event.getSource() == hourDecrementButton){
            
        }
        if(event.getSource() == minuteIncrementButton){
            
        }
        if(event.getSource() == minuteDecrementButton){
            
        }
        if(event.getSource() == repeatButton){
            
        }
        if(event.getSource() == radioFrequencyIncrementButton){
            controller.incrementStation();
        }
        if(event.getSource() == radioFrequencyDecrementButton){
            
            controller.decrementStation();
        }
        if(event.getSource() == radioVolumeIncrementButton){
            controller.radioVolumeUp();
        }
        if(event.getSource() == radioVolumeDecrementButton){
            controller.radioVolumeDown();
        
        }
        if(event.getSource() == amfmToggleButton){
            
            controller.switchRadioReceiver();
        }
        if(event.getSource() == ampmToggleButton){
        }
        if(event.getSource() == radioButton){
            if(this.radio.getOn() == false){
                
            controller.radioOn();
            
        }
            
        }
    }
          
        
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void updateMilitaryTime(int hours, int minutes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateAMPMTime(int hours, int minutes, boolean isAM) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void soundAlarm(int alarmNum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
