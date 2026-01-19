package com.gestao_escolar.api_gestao_escolar.controllers;

import com.gestao_escolar.api_gestao_escolar.dtos.Student.StudentRequestDTO;
import com.gestao_escolar.api_gestao_escolar.dtos.Student.StudentResponseDTO;
import com.gestao_escolar.api_gestao_escolar.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentResponseDTO> getStudents(@RequestParam(required = false) Long classroomId) {
        if(classroomId == null) {
            return studentService.getAllStudents();
        }

        return studentService.getStudentsByClassroomId(classroomId);
    }

    @PostMapping
    public StudentResponseDTO postStudent(@RequestBody StudentRequestDTO student){
        return studentService.postStudent(student);
    }

    @DeleteMapping
    public void deleteStudentById(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);
    }

}
