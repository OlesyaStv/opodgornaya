package ru.job4j.departments;

public class Department {

    private String code;

    public Department(String code) {
        this.code = code;
    }

    public String getKey() {
        return code;
    }

    public void setKey(String key) {
        this.code = key;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Department department = (Department) o;
        return this.code.equals(department.code);
    }

    @Override
    public int hashCode() {
        return this.code.hashCode();
    }

    public String[]  separate() {
        String[] subStr = code.split("\\\\");
        return subStr;
    }

}
