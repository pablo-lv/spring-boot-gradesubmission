package com.plucas.gradesubmission.service;

import com.plucas.gradesubmission.model.Grade;
import com.plucas.gradesubmission.repository.GradeRepository;

import java.util.List;

public class GradeService {

    GradeRepository gradeRepository = new GradeRepository();

    public List<Grade> getStudentGrades() {
        return gradeRepository.getStudentGrades();
    }


    public Grade getGrade(int index) {
        return gradeRepository.getGrade(index);
    }

    public void addGrade(Grade grade) {
        gradeRepository.addGrade(grade);
    }

    public void updateGrade(int index, Grade grade) {
        gradeRepository.updateGrade(index, grade);
    }

    public Integer getGradeIndex(String id) {
        for (int i = 0; i < getStudentGrades().size(); i++) {
            if(getStudentGrades().get(i).getId().equals(id)) return i;
        }
        return -1000;
    }

    public Grade getGradeById(String id) {
        int index = getGradeIndex(id);
        return getStudentGrades().get(index);
    }

    public void save(Grade grade) {
        if (grade.getId() == null) {
            addGrade(grade);
        } else {
            int index = getGradeIndex(grade.getId());
            if (index > -1000) {
                updateGrade(index, grade);
            }
        }
    }
}
