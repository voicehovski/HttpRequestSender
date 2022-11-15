package goit.dev.hw5.ui.commands;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.SendArbitraryRequestController;
import goit.dev.hw5.ui.View;

import java.io.File;
import java.io.IOException;

public class SendArbitraryPostCommand implements Command{
    public static final String NAME = "post";
    public static final String DESC = "Send arbitrary post request";

    private SendArbitraryRequestController controller;
    private View view;

    public SendArbitraryPostCommand(SendArbitraryRequestController controller, View view) {
        this .controller = controller;
        this.view = view;
    }

    @Override
    public boolean canExecute(String command) {
        return NAME.equalsIgnoreCase(command);
    }

    @Override
    public void execute() throws IOException {
        view.write("Enter a request");
        String request = view.read();
        view.write("Enter a filename");
        String filename = view.read();
        ResponseWrapper response = controller.sendPostFromJson(request,new File("src/main/resources/" + filename));
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
