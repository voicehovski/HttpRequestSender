package goit.dev.hw5.ui.commands;

import java.io.IOException;

public interface Command {
    boolean canExecute(String command);
    void execute() throws IOException;
    String getName();
    String getDesc();
}
