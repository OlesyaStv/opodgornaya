package ru.job4j.exchange;

public class PrintLine {
    private double price;
    private Integer volumeBid;
    private Integer volumeAsk;

    public double getPrice() {
        return this.price;
    }

    public Integer getVolumeAsk() {
        return volumeAsk;
    }

    public Integer getVolumeBid() {
        return volumeBid;
    }

    public PrintLine(double price, Integer volumeBid, Integer volumeAsk) {
        this.price = price;
        this.volumeBid = volumeBid;
        this.volumeAsk = volumeAsk;
    }
}


