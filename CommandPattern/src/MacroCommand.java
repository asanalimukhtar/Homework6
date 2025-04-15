//MacroCommand groups multiple commands together
//When executed, it runs each command in order
//When undone, it undoes them in reverse order
import java.util.ArrayList;
import java.util.List;

public class MacroCommand implements Command {
    private List<Command> commands = new ArrayList<>();
    // Add a command to the macro command lisеt
    public void addCommand(Command command) {
        commands.add(command);
    }

    @Override
    public void execute() {// Execute each command in order
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {// Undo each command in the reverse order
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }
}