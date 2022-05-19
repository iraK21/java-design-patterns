package org.example.structural.adapter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AdapterTest {
    @Test
    void testRoundPegsFitRoundHoles() {
        RoundPeg roundPeg1 = new RoundPeg(2);
        RoundPeg roundPeg2 = new RoundPeg(5);
        RoundHole roundHole = new RoundHole(4);
        assertTrue(roundHole.fits(roundPeg1));
        assertFalse(roundHole.fits(roundPeg2));
    }

    @Test
    void testSquarePegsDoNotFitRoundHolesWithoutAdapter() {
        SquarePeg squarePeg = new SquarePeg(2);
        RoundHole roundHole = new RoundHole(4);
        // assertTrue(roundHole.fits(squarePeg)); - won't compile
    }

    @Test
    void testSquarePegsFitRoundHolesWithAdapter() {
        SquarePeg squarePeg1 = new SquarePeg(4);
        SquarePeg squarePeg2 = new SquarePeg(6);
        RoundHole roundHole = new RoundHole(4);

        SquarePegToRoundHoleAdapter adapter1 = new SquarePegToRoundHoleAdapter(squarePeg1);
        SquarePegToRoundHoleAdapter adapter2 = new SquarePegToRoundHoleAdapter(squarePeg2);
        assertTrue(roundHole.fits(adapter1));
        assertFalse(roundHole.fits(adapter2));
    }
}
