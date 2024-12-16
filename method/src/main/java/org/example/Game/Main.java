package org.example.Game;

public class Main {
    public static void main(String[] args) {

        Character character = new Character("쭈니",1, "모험가");
//        모험가의 레벨 대미지 체력
        System.out.println(character.name);
        System.out.println(character.characterClass);
        System.out.println(character.level);
        System.out.println(character.Damage);

//        레벨업
        for (int i = 1; i < 10; i++) {
            System.out.println(character.levelUp());

        }

//        레벨업 후 대미지, 레벨
        System.out.println(character.level);
        System.out.println(character.Damage);


        Warrior warrior = new Warrior(character.name,character.level, character.characterClass);
        System.out.println(warrior.WarriorClassChange());
        System.out.println(warrior.characterClass);

    }



}
