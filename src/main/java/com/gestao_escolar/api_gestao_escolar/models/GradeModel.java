package com.gestao_escolar.api_gestao_escolar.models;

import jakarta.persistence.*;
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
    private String studentName;
    private String subject;
    private BigDecimal value;

    public GradeModel(Long studentId, String studentName, String subject, BigDecimal value) {
        this.studentId = studentId;
        this.subject = subject;
        this.value = value;
    }
}
