package ecole.gestionecole.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import ecole.gestionecole.DTO.StudentDTO;
import ecole.gestionecole.entites.Student;
import ecole.gestionecole.mapper.Mapper;
import ecole.gestionecole.repositories.StudentRepository;
import ecole.gestionecole.services.StudentService;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    
    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map( Mapper.INSTANCE::toStudentDTO)
                .toList();
    }

    @Override
    public StudentDTO getStudentById(Integer id) {
        return studentRepository.findById(id)
                .map(Mapper.INSTANCE::toStudentDTO)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + id));
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {

        if(studentRepository.existsByEmail(studentDTO.getEmail())) {
            throw new IllegalArgumentException("Student with the same email already exists");
        }

        Student student = Mapper.INSTANCE.toStudent(studentDTO);
        Student savedStudent = studentRepository.save(student);

        return Mapper.INSTANCE.toStudentDTO(savedStudent);
    }

    @Override
    public StudentDTO updateStudent(Integer id, StudentDTO studentDTO) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + id));     

        if(!existingStudent.getEmail().equals(studentDTO.getEmail()) 
            && studentRepository.existsByEmail(studentDTO.getEmail())) {
            throw new IllegalArgumentException("Student with the same email already exists");
        }

        Student updatedStudent = Mapper.INSTANCE.toStudent(studentDTO);
        updatedStudent.setId(id);
        Student savedStudent = studentRepository.save(updatedStudent);

        return Mapper.INSTANCE.toStudentDTO(savedStudent);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<StudentDTO> getStudentsByClassId(Integer classId) {
        return studentRepository.findByClassEntityId(classId).stream()
                .map(Mapper.INSTANCE::toStudentDTO)
                .toList();
    }
    

}
