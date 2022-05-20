package org.example.structural.decorator;

// Component interface
public interface DataSource {
    void writeData(String data);

    String readData();
}
