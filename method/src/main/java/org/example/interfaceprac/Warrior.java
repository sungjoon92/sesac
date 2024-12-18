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
        System.out.println(MessageFormat.format("레벨이 상승하였습니다! 현재레벨: {0} 최대체력 상승: {1} 데미지 상승: {2}", level, plusHp, plusDamage));
    }

    @Override
    public void angerGauge() {
        hp -= 1;
        if (MAX_ANGER > anger) {
            anger += 1;
        } else {
            anger = MAX_ANGER;
        }// if() end
        System.out.printf("현재hp:%d 분노게이지: %d%n", hp, anger);
    }
}
