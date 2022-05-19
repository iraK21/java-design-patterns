package org.example.structural.adapter;

public class SquarePegToRoundHoleAdapter extends RoundPeg { // extending RoundPeg so that adapter objects can act as RoundPegs
    private final SquarePeg squarePeg; // Wrapper around SquarePeg

    public SquarePegToRoundHoleAdapter(SquarePeg squarePeg) {
        this.squarePeg = squarePeg;
    }

    @Override
    public double getRadius() {
        // Here we return the radius of the smallest circle that can fit the SquarePeg
        return squarePeg.getWidth() * Math.sqrt(2) / 2;
    }
}
