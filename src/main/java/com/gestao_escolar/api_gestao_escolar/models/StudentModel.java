package com.gestao_escolar.api_gestao_escolar.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_students")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentModel {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer age;
    private Long classroomId;
    private String registration;

    public StudentModel(String name, Integer age, Long classroomId, String registration) {
        this.name = name;
        this.age = age;
        this.classroomId = classroomId;
        this.registration = registration;
    }
}
