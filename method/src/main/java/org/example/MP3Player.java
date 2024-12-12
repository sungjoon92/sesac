package org.example;

public class MP3Player {

    String model;
    int volume;
    boolean power;

    public MP3Player(String model, int volume, boolean power) {
        this.model = model;
        this.volume = volume;
        this.power = power;
    }

    boolean powerOn() {
         this.volume = 40;
         return this.power = true;
    }

    boolean powerOut() {
        this.volume = 0;
        return this.power = false;
    }

    int plusvolume() {
        if (this.volume >= 100) {
            this.volume = 100;
            return this.volume;
        }
        this.power = true;
        return this.volume += 20;
    }

    int minusVolume() {
        if (this.volume <= 20) {
            this.power = false;
            this.volume = 0;

            return this.volume;
        }
        return this.volume -= 20;
    }

    void showMP3() {
        System.out.println("모델명 : " + this.model + " 볼륨 : " + this.volume + " 전원 : " + this.power);
    }
}
