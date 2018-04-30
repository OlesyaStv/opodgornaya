package ru.job4j.exchange;

public class Request {

    private Integer id;
    private Integer book;
    private String type;
    private String action;
    private double price;
    private Integer volume;

    public String getAction() {
        return action;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Request request = (Request) o;
        if (this.id.equals(request.id) && this.book.equals(request.book)
                && this.action.equals(request.action) && (this.price == request.price)
                && this.volume.equals(request.volume)) {
            return true;
        }
        return false;
    }

    public Integer getVolume() {
        return this.volume;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer bookHashCode() {
        return this.book.hashCode();
    }

    public String getType() {
        return type;
    }

    public Request(int id, Integer book, String type, String action, double price, int volume) {
        this.id = id;
        this.book = book;
        this.type = type;
        this.action = action;
        this.price = price;
        this.volume = volume;
    }

}
