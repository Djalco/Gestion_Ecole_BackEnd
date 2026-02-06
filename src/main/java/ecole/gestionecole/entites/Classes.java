package ecole.gestionecole.entites;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "classes")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor  
@Builder
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column (nullable = false, unique = true)
    String nom;
    
    
}
