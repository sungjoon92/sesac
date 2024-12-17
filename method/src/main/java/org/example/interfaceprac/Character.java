package org.example.interfaceprac;

public abstract class Character {
    public String name;
    public String characterClass;
    public int level;
    public int hp;
    public int damage;

    // 생성자함수
    public  Character(String name) {
        this.name = name;
        this.characterClass = "모험가";
        this.level = 1;
        this.hp = 100;
        this.damage = 5;
    }// Character() end


}
