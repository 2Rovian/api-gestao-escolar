package com.gestao_escolar.api_gestao_escolar.dtos.reportcard;

import com.gestao_escolar.api_gestao_escolar.models.GradeModel;

import java.math.BigDecimal;
import java.util.List;

public record ReportCardRequestDTO(
        String studentName,
        String studentId,
        Long studentClassroomId,
        Long studentClassroomName,
        List<GradeModel> grades,
        BigDecimal average,
        String status
) {
}
