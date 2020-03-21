package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {

    @Test
    public void noArgsAllByDefault() {
        Radio radio = new Radio();
        radio.increaseVolume();
        radio.increaseVolume();
        radio.decreaseVolume();
        radio.increaseChannel();
        radio.increaseChannel();
        radio.increaseChannel();
        radio.decreaseChannel();
        assertEquals(2, radio.getCurrentChannel());
        assertEquals(1, radio.getCurrentVolume());
        assertEquals(9, radio.getMaxChannel());
        assertEquals(0, radio.getMinChannel());
        assertEquals(100, radio.getMaxVolume());
        assertEquals(0, radio.getMinVolume());
    }

    @Test
    public void nextChannel() {
        Radio radio = new Radio(50, 55, 10);
        radio.increaseChannel();
        assertEquals(11, radio.getCurrentChannel());
        assertEquals(55, radio.getCurrentVolume());
        assertEquals(50, radio.getMaxChannel());
    }
    @Test
    public void nextChannelFromMax() {
        Radio radio = new Radio(50, 0, 50);
        radio.increaseChannel();
        assertEquals(0, radio.getCurrentChannel());
        assertEquals(0, radio.getCurrentVolume());
        assertEquals(50, radio.getMaxChannel());
    }

    @Test
    public void previousChannel() {
        Radio radio = new Radio(100, 33, 100);
        radio.decreaseChannel();
        assertEquals(99, radio.getCurrentChannel());
        assertEquals(33, radio.getCurrentVolume());
        assertEquals(100, radio.getMaxChannel());
    }

    @Test
    public void previousChannelFromMin() {
        Radio radio = new Radio(100, 33, 0);
        radio.decreaseChannel();
        assertEquals(100, radio.getCurrentChannel());
        assertEquals(33, radio.getCurrentVolume());
        assertEquals(100, radio.getMaxChannel());
    }

    @Test
    public void turnVolumeUp() {
        Radio radio = new Radio(50, 99, 10);
        radio.increaseVolume();
        assertEquals(10, radio.getCurrentChannel());
        assertEquals(100, radio.getCurrentVolume());
        assertEquals(50, radio.getMaxChannel());
    }

    @Test
    public void turnVolumeUpFromMax() {
        Radio radio = new Radio(50, 100, 10);
        radio.increaseVolume();
        assertEquals(10, radio.getCurrentChannel());
        assertEquals(100, radio.getCurrentVolume());
        assertEquals(50, radio.getMaxChannel());
    }

    @Test
    public void turnVolumeDown() {
        Radio radio = new Radio(50, 1, 10);
        radio.decreaseVolume();
        assertEquals(10, radio.getCurrentChannel());
        assertEquals(0, radio.getCurrentVolume());
        assertEquals(50, radio.getMaxChannel());
    }

    @Test
    public void turnVolumeDownFromMin() {
        Radio radio = new Radio(50, 0, 10);
        radio.decreaseVolume();
        assertEquals(10, radio.getCurrentChannel());
        assertEquals(0, radio.getCurrentVolume());
        assertEquals(50, radio.getMaxChannel());
    }

}

