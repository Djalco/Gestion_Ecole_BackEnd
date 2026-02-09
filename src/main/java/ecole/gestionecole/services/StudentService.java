package ecole.gestionecole.services;

import java.util.List;

import ecole.gestionecole.DTO.StudentDTO;

public interface StudentService {
    
    //-----------
    // CRUD operations for Student  
    //-----------
    List<StudentDTO> getAllStudents();
    StudentDTO getStudentById(Integer id);  
    StudentDTO createStudent(StudentDTO studentDTO);
    StudentDTO updateStudent(Integer id, StudentDTO studentDTO);
    void deleteStudent(Integer id);

    //-----------
    // Additional operations for Student
    //-----------
    List<StudentDTO> getStudentsByClassId(Integer classId);
    
}
