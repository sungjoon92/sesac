package org.example.interfaceprac;

import java.text.MessageFormat;

public class Warrior extends Character implements Warriorable {
    public int plusHp = 30;
    public int plusDamage = 10;
    public int anger;
    public final int MAX_ANGER = 100;

    public Warrior(String name) {
        super(name);
        characterClass = "워리어";
        level = 1;
        hp = 120;
        damage = 10;
        anger = 0;
    }

    // 케릭터 정보 불러오기
    public void info() {
        System.out.println(MessageFormat.format("이름: {0}\n클래스: {1}\n레벨: {2}\n체력: {3}\n데미지: {4}", name, characterClass, level, hp, damage));
    }

    public void levelUp() {
        level++;
        hp += 30;
        damage += 10;
        System.out.println("레벨이 상승하였습니다! 현재레벨: " + level + " 최대체력 상승: " + plusHp + " 데미지 상승: " + plusDamage);
    }

    @Override
    public void angerGauge() {
        hp -= 1;
        if (MAX_ANGER > anger) {
            anger += 1;
        } else {
            anger = MAX_ANGER;
        }// if() end
        System.out.println("현재hp:" + hp + " 분노게이지: " + anger);
    }
}
