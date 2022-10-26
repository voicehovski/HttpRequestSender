package goit.dev.hw5.ui.commands;

public class ExitCommand implements Command {
    public static final String NAME = "exit";
    public static final String DESC = "Exit application";

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getDesc() {
        return DESC;
    }
}
