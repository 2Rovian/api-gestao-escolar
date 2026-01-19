package com.gestao_escolar.api_gestao_escolar.repositories;

import com.gestao_escolar.api_gestao_escolar.models.ClassroomModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<ClassroomModel, Long> {
}
