//Command to set the thermostat to a specific temperature.It saves the previous temperature to allow for undo.
public class SetThermostatCommand implements Command {
    private Thermostat thermostat;
    private int newTemperature;
    private int previousTemperature;
    public SetThermostatCommand(Thermostat thermostat, int newTemperature) {// Constructor that accepts a Thermostat device and the new temperature
        this.thermostat = thermostat;
        this.newTemperature = newTemperature;
    }
    @Override
    public void execute() {// Saves the current temperature and sets a new temperature
        previousTemperature = thermostat.getCurrentTemperature();
        thermostat.setTemperature(newTemperature);
    }

    @Override
    public void undo() {// Undo the command by reverting to the previous temperature
        thermostat.revertTemperature(previousTemperature);
    }
}