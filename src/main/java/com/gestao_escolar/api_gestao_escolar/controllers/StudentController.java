package com.gestao_escolar.api_gestao_escolar.controllers;

import com.gestao_escolar.api_gestao_escolar.dtos.Student.StudentRequestDTO;
import com.gestao_escolar.api_gestao_escolar.dtos.Student.StudentResponseDTO;
import com.gestao_escolar.api_gestao_escolar.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getStudents(@RequestParam(required = false) Long classroomId) {
        if(classroomId == null) {
            return ResponseEntity.ok(studentService.getAllStudents());
        }

        return ResponseEntity.ok(studentService.getStudentsByClassroomId(classroomId));
    }

    @GetMapping
    public ResponseEntity<Optional<StudentResponseDTO>> getStudentById(@PathVariable Long studentId) {
        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> postStudent(@RequestBody StudentRequestDTO student){
        return ResponseEntity.ok(studentService.postStudent(student));
    }

    @DeleteMapping
    public void deleteStudentById(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);
    }

}
