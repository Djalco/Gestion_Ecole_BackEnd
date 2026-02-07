package ecole.gestionecole.services;

import java.util.List;

import ecole.gestionecole.DTO.SubjectDTO;

public interface SubjectService {
    
    //-----------
    // CRUD operations for Subject
    //-----------
    List<SubjectDTO> getAllSubjects();
    SubjectDTO getSubjectById(Integer id);
    SubjectDTO createSubject(SubjectDTO subjectDTO);
    SubjectDTO updateSubject(Integer id, SubjectDTO subjectDTO);
    void deleteSubject(Integer id);
}
