package com.gestao_escolar.api_gestao_escolar.repositories;

import com.gestao_escolar.api_gestao_escolar.models.GradeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface GradeRepository extends JpaRepository<GradeModel, Long> {
    List<GradeModel> findByStudentId(Long studentId);
}
