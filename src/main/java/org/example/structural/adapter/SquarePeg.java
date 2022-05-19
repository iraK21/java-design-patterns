package org.example.structural.adapter;

// Incompatible with Target interface, implementation cannot be changed
public class SquarePeg {
    private final double width;

    public SquarePeg(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }
}
