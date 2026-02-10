package ecole.gestionecole.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecole.gestionecole.entites.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findByEmail(String email);
    List<Student> findByClassEntityId(Integer classId);
    boolean existsByEmail(String email);
}