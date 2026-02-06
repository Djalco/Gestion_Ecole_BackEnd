package ecole.gestionecole.entites;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "professor_classes")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfessorClass {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    
    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    Teacher teacher;
    
    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    Classes classEntity;
}