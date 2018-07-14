package ru.job4j.nonblock;


import java.util.concurrent.ConcurrentHashMap;

public class NonBlock {

    private ConcurrentHashMap<Integer, Base> storage;

    public void add(Base model) {
        storage.putIfAbsent(model.getId(), model);
    }

    public void delete(Base model) {
        storage.remove(model.getId(), model);
    }

    public Base getModel(Integer id) {
        return storage.get(id);
    }

    public void update(Base model, int version) {
        storage.computeIfPresent(model.getId(), (k, v) ->
        {
            if (v.getVersion() != version) {
                throw new OptimisticException("Versions differ!");
            } else {
                return model;
            }
        });
    }

    public NonBlock() {
        storage = new ConcurrentHashMap<>();
    }

}
