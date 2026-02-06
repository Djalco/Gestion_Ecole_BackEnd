package ecole.gestionecole.repositories;

import ecole.gestionecole.entites.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {
    List<Note> findByStudentId(Integer studentId);
    List<Note> findBySubjectId(Integer subjectId);
    List<Note> findByProfessorClassId(Integer professorClassId);
}