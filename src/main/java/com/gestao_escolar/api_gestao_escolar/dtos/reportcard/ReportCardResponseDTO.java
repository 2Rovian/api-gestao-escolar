package com.gestao_escolar.api_gestao_escolar.dtos.reportcard;

import com.gestao_escolar.api_gestao_escolar.models.GradeModel;
import jakarta.persistence.OneToMany;

import java.math.BigDecimal;
import java.util.List;

public record ReportCardResponseDTO(
        Long id,
        String studentName,
        Long studentId,
        Long studentClassroomId,
        List<GradeModel> grades,
        BigDecimal average,
        String status
) {
}
