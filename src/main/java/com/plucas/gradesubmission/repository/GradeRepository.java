package com.plucas.gradesubmission.repository;

import com.plucas.gradesubmission.model.Grade;

import java.util.ArrayList;
import java.util.List;

public class GradeRepository {

    private List<Grade> studentGrades = new ArrayList<>();

    public List<Grade> getStudentGrades() {
        return studentGrades;
    }


    public Grade getGrade(int index) {
        return studentGrades.get(index);
    }

    public void addGrade(Grade grade) {
        studentGrades.add(grade);
    }

    public void updateGrade(int index, Grade grade) {
        studentGrades.add(index, grade);
    }
}
