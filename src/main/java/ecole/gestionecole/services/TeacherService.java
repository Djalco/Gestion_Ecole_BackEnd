package ecole.gestionecole.services;

import java.util.List;

import ecole.gestionecole.DTO.TeacherDTO;

public interface TeacherService {
    //-----------
    // CRUD operations for Teacher  
    //-----------
    List<TeacherDTO> getAllTeachers();
    TeacherDTO getTeacherById(Integer id);  
    TeacherDTO createTeacher(TeacherDTO teacherDTO);
    TeacherDTO updateTeacher(Integer id, TeacherDTO teacherDTO);
    void deleteTeacher(Integer id);

    //-----------
    // Additional operations for Teacher
    //-----------
    List<TeacherDTO> getTeachersBySubjectId(Integer subjectId);
}
