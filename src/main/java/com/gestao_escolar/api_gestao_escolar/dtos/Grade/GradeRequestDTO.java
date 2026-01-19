package com.gestao_escolar.api_gestao_escolar.dtos.Grade;

import java.math.BigDecimal;

public record GradeRequestDTO(Long studentId, String subject, BigDecimal value) {
}
