package org.example.creational.singleton;

public final class SimpleSingleton {

    private static SimpleSingleton instance;

    private final String value;

    private SimpleSingleton(String value) {
        this.value = value;
    }

    public static SimpleSingleton getInstance(String value) {
        if (instance == null) {
            instance = new SimpleSingleton(value);
        }
        return instance;
    }

    public String getValue() {
        return value;
    }
}
