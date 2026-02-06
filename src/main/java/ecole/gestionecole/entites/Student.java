package ecole.gestionecole.entites;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Table(name = "students")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor  
@Builder
public class Student {
    
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

    @Column(nullable = false)
    LocalDate birthDate;
    
    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    Classes classEntity;
}