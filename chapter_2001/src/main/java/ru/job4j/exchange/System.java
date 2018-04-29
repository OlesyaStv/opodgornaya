package ru.job4j.exchange;

import java.util.HashMap;

public class System {
    private HashMap<Integer, Glass> glasses;

    public Glass whatGlassIs(Request request) {
        Glass glass = glasses.get(request.bookHashCode());
        if (glass == null) {
            glass = new Glass(request.bookHashCode());
            glasses.put(request.bookHashCode(), glass);
        }
        return glass;
    }

    public void requestCome(Request request) {
        if (request != null) {
            Glass glass = whatGlassIs(request);
            glass.processed(request);
        }
    }

    public void combine() {
        for (Glass glass : glasses.values()) {
            glass.combine();
        }
    }

    public Glass getGlass(Integer hashCode) {
        return glasses.get(hashCode);
    }

    public System() {
        this.glasses = new HashMap<>();
    }

}
