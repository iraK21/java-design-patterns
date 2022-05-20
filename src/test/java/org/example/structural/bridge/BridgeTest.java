package org.example.structural.bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BridgeTest {

    @Test
    void testRadioBasicRemote() {
        Device radio = new Radio();
        Remote basicRemote = new BasicRemote(radio);

        assertFalse(radio.isEnabled());
        assertEquals(-1, radio.getVolume());
        assertEquals(-1, radio.getChannel());

        basicRemote.volumeUp();
        basicRemote.channelDown();
        assertEquals(-1, radio.getVolume());
        assertEquals(-1, radio.getChannel());

        basicRemote.power();
        assertTrue(radio.isEnabled());
        assertEquals(15, radio.getVolume());
        assertEquals(1, radio.getChannel());

        basicRemote.volumeDown();
        assertEquals(14, radio.getVolume());

        basicRemote.volumeUp();
        assertEquals(15, radio.getVolume());

        basicRemote.channelUp();
        assertEquals(2, radio.getChannel());

        basicRemote.channelDown();
        assertEquals(1, radio.getChannel());

        basicRemote.power();
        assertFalse(radio.isEnabled());
        assertEquals(-1, radio.getVolume());
        assertEquals(-1, radio.getChannel());
    }

    @Test
    void testTelevisionAdvancedRemote() {
        Device television = new Television();
        AdvancedRemote advancedRemote = new AdvancedRemote(television);

        assertFalse(television.isEnabled());
        assertEquals(-1, television.getVolume());
        assertEquals(-1, television.getChannel());

        advancedRemote.volumeDown();
        advancedRemote.channelUp();
        assertEquals(-1, television.getVolume());
        assertEquals(-1, television.getChannel());

        advancedRemote.power();
        assertTrue(television.isEnabled());
        assertEquals(30, television.getVolume());
        assertEquals(1, television.getChannel());

        advancedRemote.volumeDown();
        assertEquals(29, television.getVolume());

        advancedRemote.volumeUp();
        assertEquals(30, television.getVolume());

        advancedRemote.channelUp();
        advancedRemote.channelUp();
        assertEquals(3, television.getChannel());

        advancedRemote.channelDown();
        assertEquals(2, television.getChannel());

        advancedRemote.mute();
        assertEquals(0, television.getVolume());

        advancedRemote.power();
        assertFalse(television.isEnabled());
        assertEquals(-1, television.getVolume());
        assertEquals(-1, television.getChannel());


    }
}
