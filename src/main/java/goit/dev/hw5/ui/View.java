package goit.dev.hw5.ui;

public interface View {
    String read ();
    void write(Object message);

    String enterParameter(String message, String defaultValue);

    String enterParameter(String message);
}
