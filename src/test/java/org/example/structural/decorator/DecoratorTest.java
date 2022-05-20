package org.example.structural.decorator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DecoratorTest {
    private static final String FILE_NAME = "out/file.txt";

    private static final Path FILE_PATH = Paths.get(FILE_NAME);

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(FILE_PATH);
        assertFalse(Files.exists(FILE_PATH));
    }

    @Test
    void testWithoutDecorator() {
        String data = "Name,Age\nIra,23\nIsha,18";
        DataSource dataSource = new FileDataSource(FILE_NAME);
        dataSource.writeData(data);
        assertTrue(Files.exists(FILE_PATH));
        assertEquals(data, dataSource.readData());
    }

    @Test
    void testWithOneDecorator() {
        String data = "Name,Age\nIra,23\nIsha,18";
        DataSource dataSource = new CompressionDataSourceDecorator(new FileDataSource(FILE_NAME));
        dataSource.writeData(data);
        assertTrue(Files.exists(FILE_PATH));
        assertEquals(data, dataSource.readData());
    }

    @Test
    void testWithNestedDecorators() {
        String data = "Name,Age\nIra,23\nIsha,18";
        DataSource dataSource = new CompressionDataSourceDecorator(new EncryptionDataSourceDecorator(new FileDataSource(FILE_NAME)));
        dataSource.writeData(data);
        assertTrue(Files.exists(FILE_PATH));
        assertEquals(data, dataSource.readData());
    }
}
