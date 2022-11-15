package goit.dev.hw5.ui;

import java.util.Scanner;

public class DefaultView implements View {
    Scanner scanner = new Scanner(System.in);

    @Override
    public String read() {
        return scanner.nextLine();
    }

    @Override
    public void write(Object message) {
        System.out.println(message);
    }

    @Override
    public String enterParameter(String message, String defaultValue){
        write(String.format("%s(%s):", message, defaultValue));
        String value = read();
        if (value.isBlank()) {
            return defaultValue;
        }
        return value;
    }
    @Override
    public String enterParameter(String message){
        write(String.format("%s:", message));
        return read();
    }
}
