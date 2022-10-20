package com.plucas.gradesubmission.controller;

import com.plucas.gradesubmission.model.Grade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GradeController {

    List<Grade> studentGrades = new ArrayList<>();

    @RequestMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", studentGrades);
        return "grades";
    }


    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        Grade grade = new Grade();
        if (getGradeIndex(id) > -1000) {
            grade = studentGrades.get(getGradeIndex(id));
        }
        model.addAttribute("grade", grade);
        return "form";
    }


    @PostMapping("/handleSubmit")
    public String submitGrade(Grade grade) {
        System.out.println(grade);
        Integer index = getGradeIndex(grade.getId());
        if (index > -1000) {
            studentGrades.set(index, grade);
        } else {
            studentGrades.add(grade);
        }
        return "redirect:/grades";
    }

    public Integer getGradeIndex(String id) {
        for (int i = 0; i < studentGrades.size(); i++) {
            if(studentGrades.get(i).getId().equals(id)) return i;
        }
        return -1000;
    }
}
