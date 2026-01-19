package com.gestao_escolar.api_gestao_escolar.services;

import com.gestao_escolar.api_gestao_escolar.dtos.Grade.GradeRequestDTO;
import com.gestao_escolar.api_gestao_escolar.dtos.Grade.GradeResponseDTO;
import com.gestao_escolar.api_gestao_escolar.models.GradeModel;
import com.gestao_escolar.api_gestao_escolar.repositories.GradeRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class GradeService {
    private final GradeRepository gradeRepository;
    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public GradeResponseDTO postGrade(GradeRequestDTO grade){
        var newGrade = gradeRepository.save(
                new GradeModel(
                        grade.studentId(),
                        grade.subject(),
                        grade.value())
        );

        return new GradeResponseDTO(
                newGrade.getId(),
                newGrade.getStudentId(),
                newGrade.getSubject(),
                newGrade.getValue()
        );
    }

    public Optional<GradeResponseDTO> getGradeById(Long gradeId){
        return gradeRepository.findById(gradeId).map(grade -> new GradeResponseDTO(
                grade.getId(),
                grade.getStudentId(),
                grade.getSubject(),
                grade.getValue()
        ));
    }

    public void deleteGrade(Long gradeId) {
        gradeRepository.deleteById(gradeId);
    }
}
