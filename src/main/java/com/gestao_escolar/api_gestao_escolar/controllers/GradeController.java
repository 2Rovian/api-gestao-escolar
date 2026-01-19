package com.gestao_escolar.api_gestao_escolar.controllers;

import com.gestao_escolar.api_gestao_escolar.services.GradeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/grades")
public class GradeController {
    private final GradeService gradeService;
    public GradeController(GradeService gradeService){
        this.gradeService = gradeService;
    }


}
