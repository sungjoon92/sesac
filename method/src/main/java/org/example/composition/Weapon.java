package org.example.composition;

public abstract class Weapon {
    protected int power;
    protected int stemina;

    public Weapon(int power, int stemina) {
        this.power = power;
        this.stemina = stemina;
    }
}
