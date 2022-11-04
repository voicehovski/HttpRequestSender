package goit.dev.hw5;

import goit.dev.hw5.controller.*;
import goit.dev.hw5.controller.pet.*;
import goit.dev.hw5.controller.store.DeleteOrderController;
import goit.dev.hw5.controller.store.GetAdditionalPropertiesController;
import goit.dev.hw5.controller.store.GetOrderController;
import goit.dev.hw5.controller.store.PostOrderController;
import goit.dev.hw5.controller.user.*;
import goit.dev.hw5.ui.*;
import goit.dev.hw5.ui.commands.*;
import goit.dev.hw5.ui.commands.pet.*;
import goit.dev.hw5.ui.commands.store.CreateOrderCommand;
import goit.dev.hw5.ui.commands.store.GetInventoryCommand;
import goit.dev.hw5.ui.commands.store.GetOrderCommand;
import goit.dev.hw5.ui.commands.store.RemoveOrderCommand;
import goit.dev.hw5.ui.commands.user.*;

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
                ),
                new CreatePetCommand(
                        new PostPetController(sendArbitraryRequestController),
                        view
                ),
                new GetPetCommand(
                        new GetPetController(sendArbitraryRequestController),
                        view
                ),
                new GetPetByStatusCommand(
                        new GetPetByStatusController(sendArbitraryRequestController),
                        view
                ),
                new EditPetCommand(
                        new PutPetController(sendArbitraryRequestController),
                        view
                ),
                new RemovePetCommand(
                        new DeletePetController(sendArbitraryRequestController),
                        view
                ),
                new CreateOrderCommand(
                        new PostOrderController(sendArbitraryRequestController),
                        view
                ),

                new GetOrderCommand(
                        new GetOrderController(sendArbitraryRequestController),
                        view
                ),
                new RemoveOrderCommand(
                        new DeleteOrderController(sendArbitraryRequestController),
                        view
                ),
                new GetInventoryCommand(
                        new GetAdditionalPropertiesController(sendArbitraryRequestController),
                        view
                ),
                new CreateUserCommand(
                        new PostUserController(sendArbitraryRequestController),
                        view
                ),
                new CreateUsersCommand(
                        new PostUsersController(sendArbitraryRequestController),
                        view
                ),
                new GetUserCommand(
                        new GetUserController(sendArbitraryRequestController),
                        view
                ),
                new EditUserCommand(
                        new PutUserController(sendArbitraryRequestController),
                        view
                ),
                new RemoveUserCommand(
                        new DeleteUserController(sendArbitraryRequestController),
                        view
                ),
                new LoginUserCommand(
                        new LoginUserController(sendArbitraryRequestController),
                        view
                ),
                new LogoutUserCommand(
                        new LogoutUserController(sendArbitraryRequestController),
                        view
                ),
                new UploadImagePetCommand(
                        new PostFilePetController(SERVER_URL),
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
