package ecole.gestionecole.serviceImpl;

import java.util.List;

import ecole.gestionecole.mapper.Mapper;
import ecole.gestionecole.DTO.TeacherDTO;
import ecole.gestionecole.services.TeacherService;
import ecole.gestionecole.repositories.TeacherRepository;
import ecole.gestionecole.entites.Teacher;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TeacherServiceImpl  implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    public List<TeacherDTO> getAllTeachers() {
        return teacherRepository.findAll().stream()
                .map(Mapper.INSTANCE::toTeacherDTO)
                .toList();
    }
    
    @Override
    public TeacherDTO getTeacherById(Integer id) {
        return teacherRepository.findById(id)
                .map(Mapper.INSTANCE::toTeacherDTO)
                .orElseThrow(() -> new IllegalArgumentException("Teacher not found with id: " + id));
    }

    @Override
    public TeacherDTO createTeacher(TeacherDTO teacherDTO) {
        if(teacherRepository.existsByEmail(teacherDTO.getEmail())) {
            throw new IllegalArgumentException("Teacher with the same email already exists");
        }

        Teacher teacher = Mapper.INSTANCE.toTeacher(teacherDTO);
        Teacher savedTeacher = teacherRepository.save(teacher);

        return Mapper.INSTANCE.toTeacherDTO(savedTeacher);
    }

    @Override
    public TeacherDTO updateTeacher(Integer id, TeacherDTO teacherDTO) {
        Teacher existingTeacher = teacherRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Teacher not found with id: " + id));     

        if(!existingTeacher.getEmail().equals(teacherDTO.getEmail()) 
            && teacherRepository.existsByEmail(teacherDTO.getEmail())) {
            throw new IllegalArgumentException("Teacher with the same email already exists");
        }

        Teacher updatedTeacher = Mapper.INSTANCE.toTeacher(teacherDTO);
        updatedTeacher.setId(id);
        Teacher savedTeacher = teacherRepository.save(updatedTeacher);

        return Mapper.INSTANCE.toTeacherDTO(savedTeacher);
    }

    @Override
    public void deleteTeacher(Integer id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public List<TeacherDTO> getTeachersBySubjectId(Integer subjectId) {
        return teacherRepository.findBySubjectId(subjectId).stream()
                .map(Mapper.INSTANCE::toTeacherDTO)
                .toList();
    }
    
}