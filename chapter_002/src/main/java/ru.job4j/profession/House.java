package ru.job4j.profession;

public class House {

    private int floors;
    private int appartments;
    private String address;

    public House(int floors, int appartments, String address) {
       this.floors = floors;
       this.appartments = appartments;
       this.address = address;
    }

    public int getFloors() {
        return  floors;
    }

    public int getAppartments() {
        return  appartments;
    }

    public String getAddress() {
        return  address;
    }
}
