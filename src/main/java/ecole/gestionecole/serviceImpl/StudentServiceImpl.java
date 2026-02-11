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
    private final Mapper mapper;
    //private final BCryptPasswordEncoder passwordEncoder;
    
    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map( mapper::toStudentDTO)
                .toList();
    }

    @Override
    public StudentDTO getStudentById(Integer id) {
        return studentRepository.findById(id)
                .map(mapper::toStudentDTO)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + id));
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {

        if(studentRepository.existsByEmail(studentDTO.getEmail())) {
            throw new IllegalArgumentException("Student with the same email already exists");
        }

        Student student = mapper.toStudent(studentDTO);

        //String encodedPassword = passwordEncoder.encode(student.getPassword());
        student.setPassword(student.getPassword());

        Student savedStudent = studentRepository.save(student);

        return mapper.toStudentDTO(savedStudent);
    }

   @Override
public StudentDTO updateStudent(Integer id, StudentDTO studentDTO) {
    // 1. Récupérer l'existant
    Student existingStudent = studentRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + id));

    // 2. Vérifier l'email
    if (!existingStudent.getEmail().equals(studentDTO.getEmail())
            && studentRepository.existsByEmail(studentDTO.getEmail())) {
        throw new IllegalArgumentException("Student with the same email already exists");
    }

    existingStudent.setFirstName(studentDTO.getFirstName());
    existingStudent.setLastName(studentDTO.getLastName());
    existingStudent.setEmail(studentDTO.getEmail());
    existingStudent.setPhoneNumber(studentDTO.getPhoneNumber());
    existingStudent.setBirthDate(studentDTO.getBirthDate());

    if (studentDTO.getPassword() != null && !studentDTO.getPassword().trim().isEmpty()) {
        existingStudent.setPassword(studentDTO.getPassword());
    }
    
    Student savedStudent = studentRepository.save(existingStudent);

    return mapper.toStudentDTO(savedStudent);
}

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<StudentDTO> getStudentsByClassId(Integer classId) {
        return studentRepository.findByClassEntityId(classId).stream()
                .map(mapper::toStudentDTO)
                .toList();
    }

}
