import java.util.Scanner;

public class CommandDemo {
    public static void main(String[] args) {
        SmartHomeRemoteControl remote = new SmartHomeRemoteControl();
        Light livingRoomLight = new Light();
        Thermostat thermostat = new Thermostat();
        Command turnOnLight = new TurnOnLightCommand(livingRoomLight);
        Command setThermostat = new SetThermostatCommand(thermostat, 22);
        Command turnOffLight = new TurnOffLightCommand(livingRoomLight);
        MacroCommand goodNightMode = new MacroCommand();
        Command lowerThermostat = new SetThermostatCommand(thermostat, 18);
        goodNightMode.addCommand(turnOffLight);
        goodNightMode.addCommand(lowerThermostat);
        remote.setCommand("light_on", turnOnLight);
        remote.setCommand("thermostat", setThermostat);
        remote.setCommand("goodnight", goodNightMode);
        Scanner in = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("\n--- Smart Home Remote Control ---");
            System.out.println("1: Turn on Light");
            System.out.println("2: Set Thermostat to 22°C");
            System.out.println("3: Goodnight Mode");
            System.out.println("4: Undo Last Command");
            System.out.println("5: Redo Last Command");
            System.out.println("0: Exit");
            System.out.print("Enter your choice: ");
            String input = in.nextLine();
            if (input.equals("1")) {
                remote.pressButton("light_on");
            } else if (input.equals("2")) {
                remote.pressButton("thermostat");
            } else if (input.equals("3")) {
                remote.pressButton("goodnight");
            } else if (input.equals("4")) {
                remote.undoButton();
            } else if (input.equals("5")) {
                remote.redoButton();
            } else if (input.equals("0")) {
                run = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}