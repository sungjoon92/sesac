package org.example.Game;

public class Main {
    public static void main(String[] args) {

        Character character = new Character("쭈니", 1, "모험가");
//        모험가의 레벨 대미지 체력
        System.out.println(character.name);
        System.out.println(character.characterClass);
        System.out.println(character.level);
        System.out.println(character.damage);

//        레벨업
        for (int i = 1; i < 10; i++) {
            System.out.println(character.levelUp());
        }

//        레벨업 후 대미지, 레벨
        System.out.println("레벨: "  + character.level);
        System.out.println("데미지: " + character.damage);


        Warrior warrior = new Warrior(character.name, character.level, character.characterClass);
        //레벨10 달성시 전직
        System.out.println(warrior.WarriorClassChange());

        System.out.println("클래스: " + warrior.characterClass);
        System.out.println("레벨: " + warrior.level);
        System.out.println("체력: " + warrior.hp);
        System.out.println("분노게이지: " + warrior.angerGauge);

        for (int i = 0; i < 25; i++) {
        System.out.println(warrior.levelUp());
        }
    }
}
