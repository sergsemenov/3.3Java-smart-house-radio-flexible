package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Radio {
    private final int maxVolume = 100;
    private final int minVolume = 0;
    private int maxChannel = 9;
    private final int minChannel = 0;
    private int currentVolume;
    private int currentChannel;

    public void increaseVolume() {
        if (currentVolume >= maxVolume) {
            currentVolume = maxVolume;
            return;
        }
        if (currentVolume <= minVolume) {
            currentVolume = minVolume;
        }
        currentVolume++;
    }

    public void decreaseVolume() {
        if (currentVolume <= minVolume) {
            currentVolume = minVolume;
            return;
        }
        if (currentVolume > maxVolume) {
            currentVolume = maxVolume;
        }
        currentVolume--;
    }

    public void increaseChannel() {
        if (currentChannel < minChannel) {
            currentChannel = minChannel;
            return;
        }
        if (currentChannel >= maxChannel) {
            currentChannel = minChannel;
            return;
        }
        currentChannel++;
    }

    public void decreaseChannel() {
        if (currentChannel > maxChannel) {
            currentChannel = maxChannel;
            return;
        }
        if (currentChannel <= minChannel) {
            currentChannel = maxChannel;
            return;
        }
        currentChannel--;
    }
}
