package org.example.Game;

public class Warrior extends Character {
    // 분노 게이지
    public int angerGauge;

    public Warrior(String name, int level, String characterClass) {
        super(name, level, characterClass);
        this.angerGauge = 0;
    }


    // 전직 시스템(레벨 10 달성시 전직)
    public String WarriorClassChange() {
        if (this.characterClass.equals("모험가") && this.level >= 10) {
            this.characterClass = "워리어";
            this.level = 1;
            this.hp = 120;
            this.damage = 10;
            return "전직완료: " + this.characterClass;
        } else {
            return "전직 조건을 만족하지 못했습니다.";
        } //if end
    }// WarriorClassChange() end

    // 워리어 레벨업
    public String levelUp() {
        if (this.characterClass.equals("워리어")) {
            this.level++;
            this.hp += 30;
            this.angerGauge += 10;
            this.damage += 10;

            return "레벨 업! 현재레벨: " + level + " 증가된 데미지: 10 현재 데미지: " + damage + " 체력: " + hp;
        }else {
            return null;

        }

    }// levelUp() end


}
