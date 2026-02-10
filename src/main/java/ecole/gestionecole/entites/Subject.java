package ecole.gestionecole.entites;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "subjects")
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
    String name;

    @Column(nullable = false)
    Integer coefficient;
}
