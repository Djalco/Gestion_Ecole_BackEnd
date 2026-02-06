package ecole.gestionecole.DTO;

import java.time.LocalDate;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer phoneNumber;
    private String password;
    private LocalDate birthDate;
    private Integer classId;
}