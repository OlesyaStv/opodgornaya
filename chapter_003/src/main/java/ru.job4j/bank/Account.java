package ru.job4j.bank;

public class Account {
    private Double value;
    private String requisites;

    public Account(Double value,  String requisites) {
        this.requisites = requisites;
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return this.requisites.equals(account.requisites);
    }

    public int hashCode() {
        return this.requisites.hashCode();
    }
}
