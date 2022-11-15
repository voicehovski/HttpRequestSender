package goit.dev.hw5.model;

public class Tag {
    private long id;
    private String name;

    public Tag(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Tag(String name) {
        this(0, name);
    }

    @Override
    public String toString() {
        return String.format("[%d] %s", id, name);
    }
}
