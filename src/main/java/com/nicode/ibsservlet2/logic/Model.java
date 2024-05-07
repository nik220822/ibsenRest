package com.nicode.ibsservlet2.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Model {
    private static final Model instance = new Model();

    private final Map<Integer, User> model;

    private static final AtomicInteger counter = new AtomicInteger(3);

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        model = new HashMap<>();
        model.put(1, new User("Иван", "Хэпибулин", 500000));
        model.put(2, new User("Артур", "Короленко", 600000));
        model.put(3, new User("Мухамор", "Морковкин", 700000));
    }

    public void add(User user, int id) {
        model.put(id, user);
    }

    public Map<Integer, User> getFromList() {
        return model;
    }

    public static int counterPlus() {
        counter.getAndIncrement();
        return counter.get();
    }
}
