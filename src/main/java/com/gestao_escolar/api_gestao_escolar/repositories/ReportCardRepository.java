package com.gestao_escolar.api_gestao_escolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportCardRepository extends JpaRepository<ReportCardRepository, Long> {
}
