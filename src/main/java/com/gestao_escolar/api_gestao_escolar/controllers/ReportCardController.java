package com.gestao_escolar.api_gestao_escolar.controllers;

import com.gestao_escolar.api_gestao_escolar.dtos.reportcard.ReportCardResponseDTO;
import com.gestao_escolar.api_gestao_escolar.services.ReportCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/report-cards")
public class ReportCardController {
    private final ReportCardService reportCardService;
    public ReportCardController(ReportCardService reportCardService) {
        this.reportCardService = reportCardService;
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<ReportCardResponseDTO> getReportCard(@PathVariable Long studentId) {
        return ResponseEntity.ok(reportCardService.generate(studentId));
    }
}
