public class TurnOffLightCommand implements Command {
    private Light light;
    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
        System.out.println("[Light] Turning ON (Undo of Off)");
    }
}