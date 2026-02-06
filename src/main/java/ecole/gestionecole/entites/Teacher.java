package ecole.gestionecole.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@AllArgsConstructor 
@NoArgsConstructor
@Builder
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    
    @Column(nullable = false)
    String firstName;
    
    @Column(nullable = false)
    String lastName;
    
    @Column(nullable = false, unique = true)
    String email;
    
    @Column(nullable = false)
    Integer phoneNumber;
    
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$",
            message = "Password must contain at least 8 characters, with at least one digit, one uppercase letter and one special character."
    )
    @Column(nullable = false)
    String password;
    
    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    Subject subject;
}