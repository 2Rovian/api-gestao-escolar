package com.gestao_escolar.api_gestao_escolar.services;

import com.gestao_escolar.api_gestao_escolar.dtos.classroom.ClassroomRequestDTO;
import com.gestao_escolar.api_gestao_escolar.dtos.classroom.ClassroomResponseDTO;
import com.gestao_escolar.api_gestao_escolar.models.ClassroomModel;
import com.gestao_escolar.api_gestao_escolar.repositories.ClassroomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomService {
    private final ClassroomRepository classroomRepository;
    public ClassroomService(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    public List<ClassroomResponseDTO> getAllClassrooms(){
        return classroomRepository.findAll().stream().map(classroom -> new ClassroomResponseDTO(
                classroom.getId(),
                classroom.getName()
        )).toList();
    }

    public Optional<ClassroomResponseDTO> getClassRoomById(Long classroomId) {
        return classroomRepository.findById(classroomId).map(
                classroom -> new ClassroomResponseDTO(
                        classroom.getId(),
                        classroom.getName()
                ));
    }

    public ClassroomResponseDTO postClassroom(ClassroomRequestDTO classroom) {
        var newClassroom = classroomRepository.save(
                new ClassroomModel(
                        classroom.id(),
                        classroom.name()
                )
        );
        return new ClassroomResponseDTO(
                newClassroom.getId(),
                newClassroom.getName()
        );
    }

    public void deleteClassroom(Long classroomId) {
        classroomRepository.deleteById(classroomId);
    }

}
