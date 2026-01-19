package com.gestao_escolar.api_gestao_escolar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_grades")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class GradeModel {
    @Id
    @GeneratedValue
    private Long id;
    private Long studentId;
    private String subject;
    private BigDecimal value;
}
