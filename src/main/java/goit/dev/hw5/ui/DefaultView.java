package goit.dev.hw5.ui;

import java.util.Scanner;

public class DefaultView implements View {
    Scanner scanner = new Scanner(System.in);

    @Override
    public String read() {
        return scanner.nextLine();
    }

    @Override
    public void write(String message) {
        System.out.println(message);
    }

    @Override
    public void write(Number message) {
        System.out.println(message);
    }
}
