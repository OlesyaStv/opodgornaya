package ru.job4j.nonblock;

public class Base {

    private String modelName;
    private Integer id;
    private Integer version;

    public Base(String modelName, Integer id) {
        this.modelName = modelName;
        this.id = id;
        this.version = 0;
    }

    public Integer getId() {
        return this.id;
    }

    public String getModelName() {
        return this.modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
        incrementVersion();
    }

    public Integer getVersion() {
        return version;
    }

    public void incrementVersion() {
        this.version++;
    }

}
