package com.gestao_escolar.api_gestao_escolar.controllers;

import com.gestao_escolar.api_gestao_escolar.dtos.classroom.ClassroomRequestDTO;
import com.gestao_escolar.api_gestao_escolar.dtos.classroom.ClassroomResponseDTO;
import com.gestao_escolar.api_gestao_escolar.services.ClassroomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {
    private final ClassroomService classroomService;
    public ClassroomController(ClassroomService classroomService){
        this.classroomService = classroomService;
    }

    @GetMapping
    public ResponseEntity<List<ClassroomResponseDTO>> getClassroom() {
        return ResponseEntity.ok(classroomService.getAllClassrooms());
    }

    @GetMapping("/{classroomId}")
    public ResponseEntity<Optional<ClassroomResponseDTO>> getClassroomById(@PathVariable Long classroomId) {
        return ResponseEntity.ok(classroomService.getClassRoomById(classroomId));
    }

    @PostMapping
    public ResponseEntity<ClassroomResponseDTO> postClassroom(@RequestBody ClassroomRequestDTO classroom){
        return ResponseEntity.ok(classroomService.postClassroom(classroom));
    }

    @DeleteMapping
    public void deleteClassroom(@PathVariable Long classroomId) {
        classroomService.deleteClassroom(classroomId);
    }
}
