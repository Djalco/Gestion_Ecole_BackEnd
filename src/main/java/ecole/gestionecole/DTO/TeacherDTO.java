package ecole.gestionecole.DTO;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer phoneNumber;
    private String password;
    private Integer subjectId;
}