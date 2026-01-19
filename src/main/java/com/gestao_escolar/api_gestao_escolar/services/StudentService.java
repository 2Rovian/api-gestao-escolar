package com.gestao_escolar.api_gestao_escolar.services;

import com.gestao_escolar.api_gestao_escolar.dtos.Student.StudentResponseDTO;
import com.gestao_escolar.api_gestao_escolar.models.StudentModel;
import com.gestao_escolar.api_gestao_escolar.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentResponseDTO> getAllStudents() {
        var students = studentRepository.findAll();

        return students.stream().map(student -> new StudentResponseDTO(
                student.getId(), student.getName(),
                student.getAge(), student.getClassroomId(),
                student.getRegistration())).toList();
    }

    public Optional<StudentResponseDTO> getStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .map(student -> new StudentResponseDTO(
                        student.getId(),
                        student.getName(),
                        student.getAge(),
                        student.getClassroomId(),
                        student.getRegistration()
                ));
    }

    public List<StudentResponseDTO> getStudentsByClassroomId(Long classroomId){
        return studentRepository.findByClassroomId(classroomId);
    }

    public StudentResponseDTO postStudent(StudentModel studentModel) {
        studentRepository.save(studentModel);
        return new StudentResponseDTO(
                studentModel.getId(),
                studentModel.getName(),
                studentModel.getAge(),
                studentModel.getClassroomId(),
                studentModel.getRegistration()
        );
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
