package com.plucas.gradesubmission.controller;

import com.plucas.gradesubmission.model.Grade;
import com.plucas.gradesubmission.repository.GradeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class GradeController {

    GradeRepository gradeRepository = new GradeRepository();

    @RequestMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", gradeRepository.getStudentGrades());
        return "grades";
    }


    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        Grade grade = new Grade();
        int index = getGradeIndex(id);
        if (index > -1000) {
            grade = gradeRepository.getGrade(index);
        }
        model.addAttribute("grade", grade);
        return "form";
    }


    @PostMapping("/handleSubmit")
    public String submitGrade(@Valid Grade grade, BindingResult result) {
        System.out.println(grade);
        if (result.hasErrors()) {
            return "form";
        }
        Integer index = getGradeIndex(grade.getId());
        if (index > -1000) {
            gradeRepository.updateGrade(index, grade);
        } else {
            gradeRepository.addGrade(grade);
        }
        return "redirect:/grades";
    }

    public Integer getGradeIndex(String id) {
        for (int i = 0; i < gradeRepository.getStudentGrades().size(); i++) {
            if(gradeRepository.getStudentGrades().get(i).getId().equals(id)) return i;
        }
        return -1000;
    }
}
