public class Thermostat {
    private int currentTemperature = 20;
    public void setTemperature(int temperature) {
        System.out.println("[Thermostat] Setting temperature to " + temperature + "°C");
        currentTemperature = temperature;
    }
    public void revertTemperature(int previousTemperature) {
        System.out.println("[Thermostat] Reverting to previous temperature " + previousTemperature + "°C");
        currentTemperature = previousTemperature;
    }public int getCurrentTemperature() {
        return currentTemperature;
    }
}