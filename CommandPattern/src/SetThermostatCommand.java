public class SetThermostatCommand implements Command {
    private Thermostat thermostat;
    private int newTemperature;
    private int previousTemperature;
    public SetThermostatCommand(Thermostat thermostat, int newTemperature) {
        this.thermostat = thermostat;
        this.newTemperature = newTemperature;
    }
    @Override
    public void execute() {
        previousTemperature = thermostat.getCurrentTemperature();
        thermostat.setTemperature(newTemperature);
    }

    @Override
    public void undo() {
        thermostat.revertTemperature(previousTemperature);
    }
}