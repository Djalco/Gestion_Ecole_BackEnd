package ecole.gestionecole.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import ecole.gestionecole.DTO.SubjectDTO;
import ecole.gestionecole.entites.Subject;
import ecole.gestionecole.mapper.Mapper;
import ecole.gestionecole.repositories.SubjectRepository;
import ecole.gestionecole.services.SubjectService;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    
    private final SubjectRepository subjectRepository;

    @Override
    public List<SubjectDTO> getAllSubjects() {
        return subjectRepository.findAll().stream()
                .map(Mapper.INSTANCE::toSubjectDTO)
                .toList();
    }

    @Override
    public SubjectDTO getSubjectById(Integer id) {
        return subjectRepository.findById(id)
                .map(Mapper.INSTANCE::toSubjectDTO)
                .orElseThrow(() -> new IllegalArgumentException("Subject not found with id: " + id));
    }

    @Override
    public SubjectDTO createSubject(SubjectDTO subjectDTO) {
        if(subjectRepository.existsByName(subjectDTO.getName())) {
            throw new IllegalArgumentException("Subject with the same name already exists");
        }

        Subject subject = Mapper.INSTANCE.toSubject(subjectDTO);
        Subject savedSubject = subjectRepository.save(subject);

        return Mapper.INSTANCE.toSubjectDTO(savedSubject);
    }

    @Override
    public SubjectDTO updateSubject(Integer id, SubjectDTO subjectDTO) {
        Subject existingSubject = subjectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Subject not found with id: " + id));     

        if(!existingSubject.getName().equals(subjectDTO.getName()) 
            && subjectRepository.existsByName(subjectDTO.getName())) {
            throw new IllegalArgumentException("Subject with the same name already exists");
        }

        Subject updatedSubject = Mapper.INSTANCE.toSubject(subjectDTO);
        updatedSubject.setId(id);
        Subject savedSubject = subjectRepository.save(updatedSubject);

        return Mapper.INSTANCE.toSubjectDTO(savedSubject);
    }

    @Override
    public void deleteSubject(Integer id) {
        subjectRepository.deleteById(id);
    }
}