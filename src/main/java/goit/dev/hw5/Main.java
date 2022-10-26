package goit.dev.hw5;

import goit.dev.hw5.ui.*;
import goit.dev.hw5.ui.commands.*;

public class Main {
    public static final String SERVER_URL = "https://petstore.swagger.io/v2";

    public static void main(String[] args) {
        View view = new DefaultView();
        HelpCommand helpCommand = new HelpCommand(view);
        Command[] commands = {
                helpCommand,
                new ExitCommand(),
                new SendArbitraryRequestCommand(
                        new SendArbitraryRequestController(SERVER_URL),
                        view
                )
        };
        helpCommand.setCommands(commands);

        // Start UI loop
        while (true) {
            System.out.println("\nEnter a command. Type 'help' if in doubt.");
            try {
                new SendArbitraryRequestCommand(
                        new SendArbitraryRequestController(SERVER_URL),
                        view
                ).execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
            String input = view .read();
            for (Command command : commands) {
                if (command.canExecute(input)){
                    try {
                        command.execute();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Something went wrong. Try again.");
                    }
                }
            }
        }
    }
}
