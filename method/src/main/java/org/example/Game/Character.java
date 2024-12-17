package org.example.Game;

public class Character {
    public String name;
    public String characterClass;
    public int level;
    public int hp;
    public int damage;

    // 생성자함수
    public Character(String name, int level, String characterClass) {
        this.name = name;
        this.characterClass = characterClass;
        this.level = level;
        this.hp = 100;
        this.damage = 5;
    }// Character() end

    // 공격하는 메서드
    public void attack() {
        System.out.println("공격!");

    }//  attack() end

    // 레벨업 메서드
    public String levelUp() {
        this.level++;
        this.damage += 5;
        hp += 10;

        return "레벨 업! 현재레벨: " + level + " 증가된 데미지: 5 현재 데미지: " + damage + " 체력: " + hp;
    }// levelUp() end

}
