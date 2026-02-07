package ecole.gestionecole.services;

import java.util.List;

import ecole.gestionecole.DTO.ClassDTO;

public interface  ClassService {
    
    //-----------
    // CRUD operations for Classes
    //-----------
    List<ClassDTO> getAllClasses();
    ClassDTO getClassById(Integer id);
    ClassDTO createClass(ClassDTO classDTO);
    ClassDTO updateClass(Integer id, ClassDTO classDTO);
    void deleteClass(Integer id);
    

}
