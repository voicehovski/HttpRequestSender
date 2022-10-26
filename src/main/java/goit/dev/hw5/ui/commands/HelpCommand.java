package goit.dev.hw5.ui.commands;

import goit.dev.hw5.ui.View;

import java.util.Arrays;

public class HelpCommand implements Command {
    public static final String NAME = "help";
    public static final String DESC = "Type list of available commands";

    private View view;
    private Command [] commands;

    public HelpCommand (View view){
        this.view = view;
        commands = new Command[]{this};
    }

    public HelpCommand (Command [] commands, View view){
        this.view = view;
        this .commands = commands;
    }

    public void setCommands (Command [] commands) {
        this .commands = commands;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() {
        Arrays.stream(commands)
                .map(this::format)
                .forEach(view::write);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getDesc() {
        return DESC;
    }

    private String format (Command command) {
        return String.format("%s\t\t%s", command.getName(), command.getDesc());
    }
}
