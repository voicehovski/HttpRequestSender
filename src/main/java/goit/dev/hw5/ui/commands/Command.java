package goit.dev.hw5.ui.commands;

import java.io.IOException;

public interface Command {
    boolean canExecute(String command);
    void execute() throws IOException, InterruptedException;
    String getName();
    String getDesc();
}
