package org.example.collectionprac;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    public int age;
    public String subject;
    public int score;
    private Map<String, Integer> grade;

    // 기본 생성자
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.grade = new HashMap<>();
    }

    // 과목, 점수 저장
    public  Map<String , Integer> addGrade(String subject, Integer score) {
        grade.put(subject, score);
        return grade;
    }// addGrade() end

    // 학생 정보 조회
    public void showInfo() {
        System.out.println("이름: "+name);
        System.out.println("나이: "+age);
        System.out.println("과목점수: "+grade);
    }

    // 해당 학생의 평균 점수 구하기
    public double averageScore() {
        // 합계 / 계수
        Integer sum = 0;
        for (String key : grade.keySet()) {
            Integer value = grade.get(key);
            sum += value;
        }// for end
        return (double) sum / grade.size();
    }// averageScore() end

    // private 이므로 studentManager 에서 사용하기위해 getter 사용
    public String getName() {
        return name;
    }// getName() end
}// class end
