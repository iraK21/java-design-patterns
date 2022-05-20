package org.example.structural.bridge;

// ConreteImplementor
public class Radio implements Device {

    private boolean on = false;

    private int volume = 15;

    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
    }

    @Override
    public void disable() {
        on = false;
    }

    @Override
    public int getVolume() {
        if (on) {
            return volume;
        }
        return -1;
    }

    @Override
    public void setVolume(int volume) {
        if (on) {
            this.volume = Math.min(Math.max(volume, 0), 25);
        }
    }

    @Override
    public int getChannel() {
        if (on) {
            return channel;
        }
        return -1;
    }

    @Override
    public void setChannel(int channel) {
        if (on) {
            this.channel = channel;
        }
    }

    @Override
    public String toString() {
        return "Radio{" +
                "on=" + on +
                ", volume=" + volume +
                ", channel=" + channel +
                '}';
    }
}
