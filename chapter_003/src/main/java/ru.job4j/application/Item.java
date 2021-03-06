package ru.job4j.application;

public class Item {

    private String id;
    private String name;
    private String desc;
    private long created;
    private String comments;

    public Item() {
    }

    public Item(String name, String desc, long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public long getCreated() {
        return created;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getComments() {
        return comments;
    }

    public String getDesc() {
        return desc;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setCreated(long created) {
        this.created = created;
    }
}
