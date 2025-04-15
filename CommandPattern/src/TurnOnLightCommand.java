//Command to turn on the light.It calls the turnOn() method on the Light receiver
public class TurnOnLightCommand implements Command {
    private Light light;// Constructor accepts a Light device
    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {// Executes the command: turn on the light
        light.turnOn();
    }

    @Override
    public void undo() {// Undo the command: turn off the light
        light.turnOff();
        System.out.println("[Light] Turning OFF (Undo)");
    }
}