package goit.dev.hw5.ui.commands.store;

import com.google.gson.Gson;
import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.BodyController;
import goit.dev.hw5.model.Category;
import goit.dev.hw5.model.Order;
import goit.dev.hw5.model.Pet;
import goit.dev.hw5.model.Tag;
import goit.dev.hw5.ui.View;
import goit.dev.hw5.ui.commands.Command;

import java.io.IOException;
import java.util.Arrays;

public class CreateOrderCommand implements Command {
    public static final String NAME = "create order";
    public static final String DESC = "Send create order request";

    private BodyController controller;
    private View view;

    public CreateOrderCommand(BodyController controller, View view) {
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

        String json = (new Gson()).toJson(order);
        ResponseWrapper response = controller.send(json);

        view.write("Status: " + response.getStatus());
        view.write(response.getBody());
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
