package ecole.gestionecole.repositories;

import ecole.gestionecole.entites.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClassRepository extends JpaRepository<Classes, Integer> {
    Optional<Classes> findByName(String name);
    boolean existsByName(String name);

}