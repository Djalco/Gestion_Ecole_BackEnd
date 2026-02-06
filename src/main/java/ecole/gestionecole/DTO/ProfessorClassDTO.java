package ecole.gestionecole.DTO;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfessorClassDTO {
    private Integer id;
    private Integer teacherId;
    private Integer classId;
}