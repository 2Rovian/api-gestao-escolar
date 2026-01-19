package com.gestao_escolar.api_gestao_escolar.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tb_report_cards")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ReportCardModel {
    @Id
    @GeneratedValue
    private Long id;
    private String studentName;
    private Long studentId;
    private Long studentClassroomId;

    @OneToMany(mappedBy = "report_card")
    private List<GradeModel> grades;
    private BigDecimal average;
    private String status;
}