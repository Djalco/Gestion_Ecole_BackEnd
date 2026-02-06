package ecole.gestionecole.entites;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "matieres")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subject {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false, unique = true)
    String nom;

    @Column(nullable = false)
    Integer coefficient;
}
