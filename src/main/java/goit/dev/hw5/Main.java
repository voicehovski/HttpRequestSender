package goit.dev.hw5;

import goit.dev.hw5.ui.*;
import goit.dev.hw5.ui.commands.*;

public class Main {
    public static final String SERVER_URL = "https://petstore.swagger.io/v2";

    public static void main(String[] args) {
        SendArbitraryRequestController sendArbitraryRequestController = new SendArbitraryRequestController(SERVER_URL);
        View view = new DefaultView();
        HelpCommand helpCommand = new HelpCommand(view);
        Command[] commands = {
                helpCommand,
                new ExitCommand(),
                new SendArbitraryGetCommand(
                        sendArbitraryRequestController,
                        view
                ),
                new SendArbitraryPostCommand(
                        sendArbitraryRequestController,
                        view
                )
        };
        helpCommand.setCommands(commands);

        // Start UI loop
        while (true) {
            System.out.println("\nEnter a command. Type 'help' if in doubt.");
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