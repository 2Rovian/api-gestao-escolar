package com.gestao_escolar.api_gestao_escolar.repositories;

import com.gestao_escolar.api_gestao_escolar.models.GradeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<GradeModel, Long> {
    List<GradeModel> findByStudentId(Long studentId);
}
