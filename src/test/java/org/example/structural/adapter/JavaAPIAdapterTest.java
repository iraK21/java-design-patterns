package org.example.structural.adapter;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * Java API adapters are mostly used to make legacy code work with modern classes.
 */
class JavaAPIAdapterTest {
    @Test
    void testArraysAsList() {
        // Target interface - List
        String[] stringArray = new String[]{"string1", "string2"}; // Adaptee
        List<String> stringList = Arrays.asList(stringArray); // asList method adapts the array to a list
        assertThat(stringList)
                .isNotEmpty()
                .containsExactly(stringArray);
    }

    @Test
    void testCollectionsEnumeration() {
        // Target interface - Enumeration
        List<String> stringCollection = Collections.singletonList("string"); // Adaptee
        Enumeration<String> stringEnumeration = Collections.enumeration(stringCollection); // enumeration method adapts the collection to an enumeration
        assertTrue(stringEnumeration.hasMoreElements());
        assertEquals(stringCollection.get(0), stringEnumeration.nextElement());
        assertFalse(stringEnumeration.hasMoreElements());
    }

    @Test
    void testInputStreamReader() throws IOException {
        // Target interface - Reader
        InputStream inputStream = System.in; // Adaptee
        Reader reader = new InputStreamReader(inputStream); // adapts InputStream to Reader
        assertEquals(-1, reader.read());
    }
}
