package goit.dev.hw5.ui.commands;

import goit.dev.hw5.Controller;
import goit.dev.hw5.ui.View;

import java.io.IOException;
import java.sql.Date;

public class SendArbitraryRequestCommand implements Command {

        public static final String NAME = "send";
        public static final String DESC = "Sends arbitrary request";

        private Controller controller;
        private View view;

        public SendArbitraryRequestCommand(Controller controller, View view) {
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
            String responce = controller.sendRequest(request);
            view.write(responce);
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
