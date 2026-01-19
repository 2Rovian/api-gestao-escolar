package com.gestao_escolar.api_gestao_escolar.controllers;

import com.gestao_escolar.api_gestao_escolar.dtos.Grade.GradeResponseDTO;
import com.gestao_escolar.api_gestao_escolar.services.GradeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/grades")
public class GradeController {
    private final GradeService gradeService;
    public GradeController(GradeService gradeService){
        this.gradeService = gradeService;
    }

    public ResponseEntity<Optional<GradeResponseDTO>> getGradeById(@PathVariable Long gradeId) {
        return ResponseEntity.ok(gradeService.getGradeById(gradeId));
    }

    public ResponseEntity<List<GradeResponseDTO>> getGradesByStudentId(@RequestParam Long studentId) {
        return ResponseEntity.ok(gradeService.getGradesByStudentId(studentId));
    }

    public void deleteGradeById(@PathVariable Long gradeId) {
        gradeService.deleteGrade(gradeId);
    }
}
