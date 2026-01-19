package com.gestao_escolar.api_gestao_escolar.dtos.grade;

import java.math.BigDecimal;

public record GradeRequestDTO(Long studentId, String studentName, String subject, BigDecimal value) {
}
