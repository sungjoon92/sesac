package org.example.composition;

public class Gun extends Weapon implements SpecialAttackable{
    public Gun(int power, int stemina) {
        super(power, stemina);
    }

    @Override
    public void specialAttack() {
        System.out.println("shoot a gun");
    }
}
