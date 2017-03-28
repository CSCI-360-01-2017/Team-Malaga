/*
 * Assignment for CSCI 360, created by Team Malaga.
 */
package com.csci360.alarmclock;

import java.util.Arrays;
import java.util.Random;

/**
 * A class for emulating a set of viable broadcasts within a range of frequencies.
 * 
 * @author Team-Malaga
 */
public class BroadcastEmulator {
    /**
     * the number of stations possible, given the range and step
     */
    private final int possibleStations;
    /**
     * the number of clear stations within this range of frequencies
     */
    private final int[] clearStations;
    /**
     * a random number generator
     */
    private final Random rand = new Random();
    
    
    /**
     * constructor method for a broadcast emulator.
     * @param min the minimum frequency for the range in kHz
     * @param max the maximum frequency for the range in kHz
     * @param step the step value in kHz between possible broadcasts
     */
    public BroadcastEmulator(int min, int max, int step){
        possibleStations= (max-min)/step;
        clearStations = new int[possibleStations];      //clear stations has a capacity to hold all possible stations
        int current = min+(rand.nextInt(10)*step);        //clear stations are determined semi-randomly
        int index = 0;                                  //initialize index
        //populate an array of clear stations
        while (current <= max){
            clearStations[index] = current;             
            current = current+(rand.nextInt(10)*step);
            index++;
        }
        Arrays.sort(clearStations);
    }
    
    /**
     * 
     * @param frequency some frequency that may or may not be one of the clear
     * stations.
     * @return true if the frequency is a clear station, false otherwise
     */
    public boolean isAClearStation(int frequency){
        boolean contained = false; //default to not found
        if (Arrays.binarySearch(clearStations, frequency) >= 0){
            contained = true;                   //found in clear stations array
        }
        return contained;
    }
    
    /**
     * returns the array of clear stations
     * @return the array containing clear stations
     */
    public int[] getClearStations(){
        return this.clearStations;
    }
    
    /**
     * returns the number of clear stations
     * @return the number of stations possible in this range
     */
    public int getPossibleStations(){
        return this.possibleStations;
    }
}