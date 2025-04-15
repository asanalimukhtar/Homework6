package com.example.command;

//The Thermostat class represents a thermostat device.It can change its temperature and revert to a previous temperature
public class Thermostat {
    // Start with an initial temperature of 20°C
    private int currentTemperature = 20;
    // Set the thermostat to a new temperature
    public void setTemperature(int temperature) {
        System.out.println("[Thermostat] Setting temperature to " + temperature + "°C");
        currentTemperature = temperature;
    }
    // Revert to a previous temperature
    public void revertTemperature(int previousTemperature) {
        System.out.println("[Thermostat] Reverting to previous temperature " + previousTemperature + "°C");
        currentTemperature = previousTemperature;
    }
    // Get the current temperature
    public int getCurrentTemperature() {
        return currentTemperature;
    }
}