package org.example.collectionprac;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
// 학생들의 목록을 관리 (가지고 있음)
    // 학생 추가 검색
    // 학생들의 정보 조회

    private final List<Student> students;

    // 기본 생성자
    public StudentManager() {
        this.students = new ArrayList<>();
    }// StudentManager() end

    // 학생정보 저장
    public void addStudent(Student student) {
        students.add(student);
    }// addStudent() end

    // 학생들의 정보조회
    public void showStudentInfo() {
        for (Student student : students) {
            student.showInfo();
            System.out.println();
        }// for end
    }// showStudentInfo() end

    // 학생 검색
    public Student findStudentByName(String name) {
        // 이름이 같은 학생을 return
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }// if end
        }// for end
        return null;
    }// findStudentByName() end
}// class end
