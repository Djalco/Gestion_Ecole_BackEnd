package ecole.gestionecole.DTO;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectDTO {
    private Integer id;
    private String name;
    private Integer coefficient;
}