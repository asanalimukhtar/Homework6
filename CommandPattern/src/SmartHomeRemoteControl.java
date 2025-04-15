import java.util.HashMap;
import java.util.Map;

public class SmartHomeRemoteControl {
    private Map<String, Command> commandSlots = new HashMap<>();
    private Command lastCommand;
    private Command lastUndoneCommand;
    public void setCommand(String slot, Command command) {
        commandSlots.put(slot, command);
    }
    public void pressButton(String slot) {
        if (commandSlots.containsKey(slot)) {
            Command command = commandSlots.get(slot);
            command.execute();
            lastCommand = command;
        } else {
            System.out.println("No command assigned to slot: " + slot);
        }
    }
    public void undoButton() {
        if (lastCommand != null) {
            System.out.println("Undo last command");
            lastCommand.undo();
            lastUndoneCommand = lastCommand;
            lastCommand = null;
        } else {
            System.out.println("No command to undo.");
        }
    }
    public void redoButton() {
        if (lastUndoneCommand != null) {
            System.out.println("Redo last command");
            lastUndoneCommand.execute();
            lastCommand = lastUndoneCommand;
            lastUndoneCommand = null;
        } else {
            System.out.println("No command to redo.");
        }
    }
}