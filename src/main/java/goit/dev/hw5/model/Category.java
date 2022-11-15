package goit.dev.hw5.model;

public class Category {
    private long id;
    private String name;

    public Category(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String name) {
        this(0, name);
    }

    @Override
    public String toString() {
        return String.format("[%d] %s", id, name);
    }
}
