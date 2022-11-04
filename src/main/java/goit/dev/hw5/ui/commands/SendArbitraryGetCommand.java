package goit.dev.hw5.ui.commands;

import goit.dev.hw5.ResponseWrapper;
import goit.dev.hw5.controller.SendArbitraryRequestController;
import goit.dev.hw5.ui.View;

import java.io.IOException;

public class SendArbitraryGetCommand implements Command {

        public static final String NAME = "send";
        public static final String DESC = "Sends arbitrary request";

        private SendArbitraryRequestController controller;
        private View view;

        public SendArbitraryGetCommand(SendArbitraryRequestController controller, View view) {
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
            ResponseWrapper response = controller.sendGet(request);
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
