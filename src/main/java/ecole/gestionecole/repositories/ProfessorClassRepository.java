package ecole.gestionecole.repositories;

import ecole.gestionecole.entites.ProfessorClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProfessorClassRepository extends JpaRepository<ProfessorClass, Integer> {
    List<ProfessorClass> findByTeacherId(Integer teacherId);
    List<ProfessorClass> findByClassEntityId(Integer classId);
}