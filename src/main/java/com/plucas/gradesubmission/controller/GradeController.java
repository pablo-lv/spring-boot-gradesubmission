package com.plucas.gradesubmission.controller;

import com.plucas.gradesubmission.model.Grade;
import com.plucas.gradesubmission.service.GradeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class GradeController {

    GradeService gradeService = new GradeService();

    @RequestMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", gradeService.getStudentGrades());
        return "grades";
    }


    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        Grade grade = gradeService.getGradeById(id);
        if (grade == null) {
            grade = new Grade();
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

        gradeService.save(grade);
        return "redirect:/grades";
    }


}
