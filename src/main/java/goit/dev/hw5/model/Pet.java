package goit.dev.hw5.model;

import java.util.LinkedList;

public class Pet {
    private long id;
    private Category category;
    private String name;
    private String [] photoUrls;
    private Tag [] tags;
    private String status;

    public Pet(String name, String[] photoUrls) {
        this.name = name;
        this.photoUrls = photoUrls;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addTag (Tag tag) {
        /*if (tags == null) {
            tags = new LinkedList<Tag>
        }*/
        if (tags == null) {
            tags = new Tag [] {tag};
        } else {
            Tag[] newTags = new Tag[tags.length + 1];
            System.arraycopy(tags, 0, newTags, 0, tags.length);
            newTags[newTags.length - 1] = tag;
            tags = newTags;
        }
    }
}
