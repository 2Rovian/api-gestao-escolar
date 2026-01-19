package com.gestao_escolar.api_gestao_escolar.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_classrooms")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ClassroomModel {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "classroom")
    private List<StudentModel> students = new ArrayList<>();

    public ClassroomModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
