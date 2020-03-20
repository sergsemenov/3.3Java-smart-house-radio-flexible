package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {

    @Test
    public void desiredChannel() {
        Radio radio = new Radio(499);
        radio.setCurrentChannel(500);
        assertEquals(499, radio.getCurrentChannel());
    }

    @Test
    public void desiredChannelNNN() {
        Radio radio = new Radio(123456789);
        radio.setCurrentChannel(500);
        assertEquals(500, radio.getCurrentChannel());
    }

    @Test
    public void desiredChannelMinusNNN() {
        Radio radio = new Radio();
        radio.setCurrentChannel(-500);
        assertEquals(0, radio.getCurrentChannel());
    }

    @Test
    public void nextChannel() {
        Radio radio = new Radio(99);
        radio.setCurrentChannel(5);
        radio.increaseChannel();
        assertEquals(6, radio.getCurrentChannel());
    }

    @Test
    public void nextChannelFromNNN() {
        Radio radio = new Radio(501);
        radio.setCurrentChannel(500);
        radio.increaseChannel();
        assertEquals(501, radio.getCurrentChannel());
    }

    @Test
    public void nextChannelFromMinusNNN() {
        Radio radio = new Radio(5);
        radio.setCurrentChannel(-500);
        radio.increaseChannel();
        assertEquals(1, radio.getCurrentChannel());
    }

    @Test
    public void nextChannelFromMaxChannel() {
        Radio radio = new Radio();
        radio.setCurrentChannel(9);
        radio.increaseChannel();
        assertEquals(0, radio.getCurrentChannel());
    }

    @Test
    public void previousChannel() {
        Radio radio = new Radio(5);
        radio.setCurrentChannel(5);
        radio.decreaseChannel();
        assertEquals(4, radio.getCurrentChannel());
    }

    @Test
    public void previousChannelFromNNN() {
        Radio radio = new Radio(499);
        radio.setCurrentChannel(500);
        radio.decreaseChannel();
        assertEquals(498, radio.getCurrentChannel());
    }

    @Test
    public void previousChannelFromMinusNNN() {
        Radio radio = new Radio(11);
        radio.setCurrentChannel(-500);
        radio.decreaseChannel();
        assertEquals(11, radio.getCurrentChannel());
    }

    @Test
    public void previousChannelFromMinChannel() {
        Radio radio = new Radio(6);
        radio.setCurrentChannel(0);
        radio.decreaseChannel();
        assertEquals(6, radio.getCurrentChannel());
    }

    @Test
    public void increaseVolume() {
        Radio radio = new Radio(200);
        radio.setCurrentVolume(4);
        radio.increaseVolume();
        assertEquals(5, radio.getCurrentVolume());
    }

    @Test
    public void increaseVolumeFromNNN() {
        Radio radio = new Radio();
        radio.setCurrentVolume(500);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void increaseVolumeFromMinusNNN() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-500);
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    public void increaseVolumeFromMaxVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void decreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(4);
        radio.decreaseVolume();
        assertEquals(3, radio.getCurrentVolume());
    }

    @Test
    public void decreaseVolumeFromNNN() {
        Radio radio = new Radio();
        radio.setCurrentVolume(500);
        radio.decreaseVolume();
        assertEquals(99, radio.getCurrentVolume());
    }

    @Test
    public void decreaseVolumeFromMinusNNN() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-500);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void decreaseVolumeFromMinVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }
}
