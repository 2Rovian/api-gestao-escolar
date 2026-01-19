package com.gestao_escolar.api_gestao_escolar.services;

import com.gestao_escolar.api_gestao_escolar.domain.ReportCard;
import com.gestao_escolar.api_gestao_escolar.models.GradeModel;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class GradeCalculator {

    public ReportCard generateReportCard(Long studentId, List<GradeModel> grades) {

        if (grades.isEmpty()) {
            return new ReportCard(
                    studentId,
                    grades,
                    BigDecimal.ZERO,
                    "NO_GRADES"
            );
        }

        BigDecimal average = calculateAverage(grades);

        String status = average.compareTo(BigDecimal.valueOf(6)) >= 0
                ? "APPROVED"
                : "REPROVED";

        return new ReportCard(
                studentId,
                grades,
                average,
                status
        );
    }

    private BigDecimal calculateAverage(List<GradeModel> grades) {
        return grades.stream()
                .map(GradeModel::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(
                        BigDecimal.valueOf(grades.size()),
                        2,
                        RoundingMode.HALF_UP
                );
    }
}

