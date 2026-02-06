package ecole.gestionecole.entites;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "notes")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Note {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    Student student;
    
    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    Subject subject;
    
    @Column(nullable = false)
    Double value;
    
    @ManyToOne
    @JoinColumn(name = "professor_class_id", nullable = false)
    ProfessorClass professorClass;
}