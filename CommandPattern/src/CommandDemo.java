//CommandDemo is the client code which simulates a smart home remote control.It uses a simple CLI menu with if/else to let the user choose commands
import java.util.Scanner;

public class CommandDemo {
    public static void main(String[] args) {
        SmartHomeRemoteControl remote = new SmartHomeRemoteControl();// Create the remote control (invoker)
        Light livingRoomLight = new Light();// Create devices (receivers)
        Thermostat thermostat = new Thermostat();
        Command turnOnLight = new TurnOnLightCommand(livingRoomLight);
        Command setThermostat = new SetThermostatCommand(thermostat, 22);
        Command turnOffLight = new TurnOffLightCommand(livingRoomLight);
        MacroCommand goodNightMode = new MacroCommand();// In Goodnight mode, we turn off the light and lower the thermostat (e.g., to 18°C)
        Command lowerThermostat = new SetThermostatCommand(thermostat, 18);// Create command objects to control the devices
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
            if (input.equals("1")) {// Process input using if/else statements
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
                run = false;// Exit the menu loop
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}