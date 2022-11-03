package goit.dev.hw5.ui;

public interface View {
    String read ();
    void write(String message);
    void write(Number message);

    String enterParameter(String message, String defaultValue);

    String enterParameter(String message);
}
