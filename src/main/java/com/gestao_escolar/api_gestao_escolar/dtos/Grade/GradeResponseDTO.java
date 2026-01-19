package com.gestao_escolar.api_gestao_escolar.dtos.Grade;

import java.math.BigDecimal;

public record GradeResponseDTO(Long id, Long studentId, String subject, BigDecimal value ) {
}
