package ecole.gestionecole.repositories;

import ecole.gestionecole.entites.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Optional<Teacher> findByEmail(String email);
    List<Teacher> findBySubjectId(Integer subjectId);
    boolean existsByEmail(String email);
}