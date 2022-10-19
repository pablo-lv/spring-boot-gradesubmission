package com.plucas.gradesubmission.controller;

import com.plucas.gradesubmission.model.Grade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String getForm(Model model) {
        model.addAttribute("grade", new Grade());
        return "form";
    }


    @PostMapping("/handleSubmit")
    public String submitGrade(Grade grade) {
        System.out.println(grade);
        studentGrades.add(grade);
        return "redirect:/grades";
    }
}
