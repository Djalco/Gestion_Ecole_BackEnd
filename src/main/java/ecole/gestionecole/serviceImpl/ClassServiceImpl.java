package ecole.gestionecole.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import ecole.gestionecole.DTO.ClassDTO;
import ecole.gestionecole.entites.Classes;
import ecole.gestionecole.mapper.Mapper;
import ecole.gestionecole.repositories.ClassRepository;
import ecole.gestionecole.services.ClassService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {
    
    private final ClassRepository classRepository;
    private final Mapper mapper;

    @Override
    public ClassDTO createClass(ClassDTO classDTO) {
        if(classRepository.existsByName(classDTO.getName())) {
            throw new IllegalArgumentException("Class with the same name already exists");
        }

        Classes classes = mapper.toClasses(classDTO);
        Classes savedClasses = classRepository.save(classes);

        return mapper.toClassesDTO(savedClasses);
    }

    @Override
    public ClassDTO updateClass(Integer id, ClassDTO classDTO) {
        Classes classe = classRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Class not found with id: " + id));     

            if(!classe.getName().equals(classDTO.getName()) 
                && classRepository.existsByName(classDTO.getName())) {
                throw new IllegalArgumentException("Class with the same name already exists");
            }
        Classes updatedClasses = mapper.toClasses(classDTO);
        updatedClasses.setId(id);
        Classes savedClasses = classRepository.save(updatedClasses);

        return mapper.toClassesDTO(savedClasses);
    }

    @Override
    public void deleteClass(Integer id) {
        classRepository.deleteById(id);
    }

    @Override
    public List<ClassDTO> getAllClasses() {
        List<Classes> classes = classRepository.findAll();
        return classes.stream()
                .map(mapper::toClassesDTO)
                .toList();
    }

    @Override
    public ClassDTO getClassById(Integer id) {
        Classes classe = classRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Class not found with id: " + id));
        return mapper.toClassesDTO(classe);
    }
}