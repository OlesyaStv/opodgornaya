package ru.job4j.exchange;

public class Request {

    private Integer id;
    private Integer book;
    public enum Type { ADD, DELETE };
    public enum Action { BID, ASK };
    private Type type;
    private Action action;
    private double price;
    private Integer volume;
    private boolean exist;

    public Action getAction() {
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

    public Type getType() {
        return type;
    }

    public void setNotExist() {
        this.exist = false;
    }

    public boolean getExist() {
        return  this.exist;
    }

    public Request(int id, Integer book, Type type, Action action, double price, int volume) {
        this.id = id;
        this.book = book;
        this.type = type;
        this.action = action;
        this.price = price;
        this.volume = volume;
        this.exist = true;
    }

}
