package com.gestao_escolar.api_gestao_escolar.domain;

import com.gestao_escolar.api_gestao_escolar.models.GradeModel;

import java.math.BigDecimal;
import java.util.List;

public class ReportCard {

    private final Long studentId;
    private final List<GradeModel> grades;
    private final BigDecimal average;
    private final String status;

    public ReportCard(
            Long studentId,
            List<GradeModel> grades,
            BigDecimal average,
            String status
    ) {
        this.studentId = studentId;
        this.grades = grades;
        this.average = average;
        this.status = status;
    }

    public Long getStudentId() {
        return studentId;
    }

    public List<GradeModel> getGrades() {
        return grades;
    }

    public BigDecimal getAverage() {
        return average;
    }

    public String getStatus() {
        return status;
    }
}

