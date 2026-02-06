package ecole.gestionecole.DTO;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoteDTO {
    private Integer id;
    private Integer studentId;
    private Integer subjectId;
    private Double value;
    private Integer professorClassId;
}