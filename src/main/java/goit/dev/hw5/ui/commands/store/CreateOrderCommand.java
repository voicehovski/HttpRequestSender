package goit.dev.hw5.ui.commands.store;

import goit.dev.hw5.controller.store.PostOrderController;
import goit.dev.hw5.model.Order;
import goit.dev.hw5.ui.View;
import goit.dev.hw5.ui.commands.Command;

import java.io.IOException;
import java.util.Collections;

public class CreateOrderCommand implements Command {
    public static final String NAME = "create order";
    public static final String DESC = "Create new order (POST)";

    private PostOrderController controller;
    private View view;

    public CreateOrderCommand(PostOrderController controller, View view) {
        this .controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() throws IOException {
        view.write("Enter each value or just press <Enter> to leave default value (in braces)");
        String petId = view.enterParameter("Enter a pet id");
        String quantity = view.enterParameter("Enter a quantity", "1");
        String shipDate = view.enterParameter("Enter a ship date", "2022-11-10");
        String status = view.enterParameter("Enter a status", "placed");

        Order order = new Order(
            Long.parseLong(petId),
            Integer.parseInt(quantity),
            shipDate,
            status,
           true
        );

        int responseStatus = controller.send(Collections.emptyMap(), order);

        view.write("Status: " + responseStatus);
        view.write(controller.getEntity());
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
