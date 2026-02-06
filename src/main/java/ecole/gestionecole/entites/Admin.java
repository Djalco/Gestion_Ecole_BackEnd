package ecole.gestionecole.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;


@Entity
@Table(name = "admins")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Admin {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String firstName;
    String lastName;
    @Column(nullable = false, unique = true)
    String email;
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$",
            message = "Le mot de passe doit contenir au moins 8 caractères, avec au moins un chiffre, une lettre majuscule et un caractère spécial."
    )
    String password;
}
