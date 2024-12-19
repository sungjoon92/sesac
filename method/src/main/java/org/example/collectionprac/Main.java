package org.example.collectionprac;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        // 학생
        Student jooni = new Student("쮸니", 3);
        Student tengi = new Student("탱이", 5);
        Student gooi = new Student("구이", 7);

        HashMap<String, Integer> studentMap = new HashMap<>();
        studentMap.put(jooni.name,jooni.age);
        studentMap.put(tengi.name,tengi.age);
        studentMap.put(gooi.name,gooi.age);

        System.out.println(studentMap);

        // 과목
        ArrayList<String> subjects = new ArrayList<>();
        subjects.add("국어");
        subjects.add("영어");
        subjects.add("수학");
        subjects.add("과학");
        subjects.add("사회");

        System.out.println(subjects);


        jooni.subjectScore("국어", 50);

        System.out.println(jooni);


        // 점수

//        학생1이 있다.
//        학생2가 있다.
//
//        학생 관리 시스템이 있다.
//
//        학생 관리 시스템이 학생1을 관리하도록 핮.
//        학생관리시스템.니가관리하는학생들의목록을보여줘()

    }
}
