package org.example.structural.bridge;

// RefinedAbstraction
public class BasicRemote implements Remote {
    protected final Device device;

    public BasicRemote(Device device) {
        this.device = device;
    }

    @Override
    public void power() {
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    @Override
    public void volumeDown() {
        if (device.isEnabled()) {
            device.setVolume(device.getVolume() - 1);
        }
    }

    @Override
    public void volumeUp() {
        if (device.isEnabled()) {
            device.setVolume(device.getVolume() + 1);
        }
    }

    @Override
    public void channelDown() {
        if (device.isEnabled()) {
            device.setChannel(device.getChannel() - 1);
        }
    }

    @Override
    public void channelUp() {
        if (device.isEnabled()) {
            device.setChannel(device.getChannel() + 1);
        }
    }
}
