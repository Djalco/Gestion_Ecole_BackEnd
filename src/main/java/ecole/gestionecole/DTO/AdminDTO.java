package ecole.gestionecole.DTO;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}