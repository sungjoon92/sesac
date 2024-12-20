package org.example.collectionprac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 학생 정보 저장
        Student jooni = new Student("쮸니", 3);
        Student tengi = new Student("탱이", 5);
        Student gooi = new Student("구이", 7);

        // 과목 저장
        List<String> subjects = new ArrayList<>();
        subjects.add("국어");
        subjects.add("영어");
        subjects.add("수학");
        subjects.add("과학");
        subjects.add("사회");


        // 점수 넣기
        jooni.addGrade(subjects.get(0), 10);
        jooni.addGrade(subjects.get(1), 30);
        jooni.addGrade(subjects.get(2), 20);
        jooni.addGrade(subjects.get(3), 60);
        jooni.addGrade(subjects.get(4), 50);

        // 대상학생의 정보 조회
        jooni.showInfo();

        tengi.addGrade("국어", 10);
        tengi.addGrade("영어", 30);
        tengi.addGrade("수학", 20);
        tengi.addGrade("과학", 60);

        // 대상 학생의 평균 점수 조회
        System.out.println(jooni.averageScore());

        // studentManager에 학생 정보 저장
        StudentManager studentManager = new StudentManager();
        studentManager.addStudent(jooni);
        studentManager.addStudent(tengi);
        studentManager.addStudent(gooi);
        
        // 저장된 학생 정보 조회
        studentManager.showStudentInfo();

        //검색
        Student b = studentManager.findStudentByName("구이");
        b.showInfo();
    }// main end
}// class end
