//Command to turn off the light.It calls the turnOff() method on the Light receiver
public class TurnOffLightCommand implements Command {
    private Light light;
    public TurnOffLightCommand(Light light) {
        this.light = light;
    }
    // Constructor accepts a Light device
    @Override
    public void execute() {// Executes the command: turn off the light
        light.turnOff();
    }

    @Override //Undo the command: turn on the light
    public void undo() {
        light.turnOn();
        System.out.println("[Light] Turning ON (Undo of Off)");
    }
}