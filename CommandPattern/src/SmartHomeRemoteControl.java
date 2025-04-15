//SmartHomeRemoteControl acts as the invoker.It stores commands by slot names and can execute, undo, or redo commands
import java.util.HashMap;
import java.util.Map;

public class SmartHomeRemoteControl {
    private Map<String, Command> commandSlots = new HashMap<>();// Map to store commands assigned to each slot.
    private Command lastCommand;// Track the last executed command for undo functionality
    private Command lastUndoneCommand;
    public void setCommand(String slot, Command command) {
        commandSlots.put(slot, command);// Track the last undone command for redo functionality
    }// Assign a command to a specific slot
    public void pressButton(String slot) {// Execute the command assigned to the given slot
        if (commandSlots.containsKey(slot)) {
            Command command = commandSlots.get(slot);
            command.execute();
            lastCommand = command;
        } else {
            System.out.println("No command assigned to slot: " + slot);
        }
    }
    public void undoButton() {// Undo the last executed command
        if (lastCommand != null) {
            System.out.println("Undo last command");
            lastCommand.undo();
            lastUndoneCommand = lastCommand;
            lastCommand = null;
        } else {
            System.out.println("No command to undo.");
        }
    }
    public void redoButton() {// Redo the last undone command
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