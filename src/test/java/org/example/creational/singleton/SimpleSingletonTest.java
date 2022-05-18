package org.example.creational.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleSingletonTest {

    @Test
    void testSimpleSingletonSuccess() {
        SimpleSingleton simpleSingleton1 = SimpleSingleton.getInstance("string1");
        SimpleSingleton simpleSingleton2 = SimpleSingleton.getInstance("string2");
        assertEquals(simpleSingleton1, simpleSingleton2);
    }
}