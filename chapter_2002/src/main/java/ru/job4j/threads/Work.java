package ru.job4j.threads;

public class Work {
    private String name;
    private boolean isWorking;
    private Integer workTime;

    public String getName() {
        return name;
    }

    public boolean getIsWorking() {
        return isWorking;
    }

    public void setWorking(boolean isWorking) {
        this.isWorking = isWorking;
    }

    public Integer getWorkTime() {
        return workTime;
    }

    public Work(String name, Integer workTime) {
        this.name = name;
        this.isWorking = false;
        this.workTime = workTime;
    }
}
