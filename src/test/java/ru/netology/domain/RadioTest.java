package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {

    @Test
    public void noArgsAllByDefault() {
        Radio radio = new Radio();
        //увеличим на два, уменьшим на один, в итоге плюс 1 к громкости по умолчанию (0)
        radio.increaseVolume();
        radio.increaseVolume();
        radio.decreaseVolume();
        //увеличим на три, уменьшим на один, в итоге плюс два к каналу по умолчанию (0)
        radio.increaseChannel();
        radio.increaseChannel();
        radio.increaseChannel();
        radio.decreaseChannel();
        assertEquals(1, radio.getCurrentVolume());
        assertEquals(2, radio.getCurrentChannel());
        assertEquals(9, radio.getMaxChannel());
        assertEquals(0, radio.getMinChannel());
        assertEquals(100, radio.getMaxVolume());
        assertEquals(0, radio.getMinVolume());
    }

    @Test
    public void noArgsTurnUpVolumeFromAboveMax() {
        Radio radio = new Radio();
        radio.setCurrentChannel(5);
        radio.setCurrentVolume(1000);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
        assertEquals(100, radio.getMaxVolume());
        assertEquals(5, radio.getCurrentChannel());
        assertEquals(9, radio.getMaxChannel());
        assertEquals(0, radio.getMinChannel());
        assertEquals(0, radio.getMinVolume());
    }

    @Test
    public void noArgsTurnUpVolumeFromMax() {
        Radio radio = new Radio();
        radio.setCurrentChannel(5);
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
        assertEquals(100, radio.getMaxVolume());
        assertEquals(5, radio.getCurrentChannel());
        assertEquals(9, radio.getMaxChannel());
        assertEquals(0, radio.getMinChannel());
        assertEquals(0, radio.getMinVolume());
    }

    @Test
    public void noArgsTurnDownVolumeFromBelowMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-100);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
        assertEquals(0, radio.getMinVolume());
    }

        @Test
        public void noArgsTurnDownVolumeFromMin() {
            Radio radio = new Radio();
            radio.setCurrentVolume(0);
            radio.decreaseVolume();
            assertEquals(0, radio.getCurrentVolume());
            assertEquals(0, radio.getMinVolume());
        }

    @Test
    public void noArgsTurnDownVolumeFromAboveMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(1000);
        radio.decreaseVolume();
        assertEquals(99, radio.getCurrentVolume());
        assertEquals(100, radio.getMaxVolume());
    }

    @Test
    public void noArgsTurnUpVolumeFromBelowMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-100);
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
        assertEquals(0, radio.getMinVolume());
    }

    @Test
    public void previousChannelFromAboveMax() {
        Radio radio = new Radio(50, 0, 500);
        radio.decreaseChannel();
        assertEquals(50, radio.getCurrentChannel());
        assertEquals(0, radio.getCurrentVolume());
        assertEquals(50, radio.getMaxChannel());
    }

    @Test
    public void nextChannelFromAboveMax() {
        Radio radio = new Radio(50, 0, 500);
        radio.increaseChannel();
        assertEquals(0, radio.getCurrentChannel());
        assertEquals(0, radio.getCurrentVolume());
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
    public void nextChannelFromBelowMin() {
        Radio radio = new Radio(100, 33, -100);
        radio.increaseChannel();
        assertEquals(0, radio.getCurrentChannel());
        assertEquals(33, radio.getCurrentVolume());
        assertEquals(100, radio.getMaxChannel());
    }

    @Test
    public void previousChannelFromBelowMin() {
        Radio radio = new Radio(100, 33, -100);
        radio.decreaseChannel();
        assertEquals(100, radio.getCurrentChannel());
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
}
