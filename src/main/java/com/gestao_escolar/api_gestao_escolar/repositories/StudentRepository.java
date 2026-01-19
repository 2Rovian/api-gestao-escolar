package com.gestao_escolar.api_gestao_escolar.repositories;

import com.gestao_escolar.api_gestao_escolar.models.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {
    List<StudentModel> findByClassroomId(Long classroomId);
}
