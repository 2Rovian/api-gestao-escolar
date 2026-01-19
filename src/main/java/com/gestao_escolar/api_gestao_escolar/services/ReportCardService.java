package com.gestao_escolar.api_gestao_escolar.services;

import com.gestao_escolar.api_gestao_escolar.dtos.grade.GradeResponseDTO;
import com.gestao_escolar.api_gestao_escolar.dtos.reportcard.ReportCardResponseDTO;
import com.gestao_escolar.api_gestao_escolar.models.GradeModel;
import com.gestao_escolar.api_gestao_escolar.repositories.GradeRepository;
import com.gestao_escolar.api_gestao_escolar.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class ReportCardService {

    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;
    private final GradeCalculator gradeCalculator;

    public ReportCardService( GradeRepository gradeRepository, StudentRepository studentRepository, GradeCalculator gradeCalculator
    ) {
        this.gradeRepository = gradeRepository;
        this.studentRepository = studentRepository;
        this.gradeCalculator = gradeCalculator;
    }

    public ReportCardResponseDTO generate(Long studentId) {

        var student = studentRepository.findById(studentId);

        var grades = gradeRepository.findByStudentId(studentId);

        var reportCard = gradeCalculator.generateReportCard(studentId, grades);

        return new ReportCardResponseDTO(
                UUID.randomUUID().toString(),
                student.get().getName(),
                studentId,
                student.get().getClassroomId(),
                grades,
                reportCard.getAverage(),
                reportCard.getStatus()
        );
    }
}
