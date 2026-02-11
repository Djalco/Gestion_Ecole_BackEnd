package ecole.gestionecole.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import ecole.gestionecole.DTO.*;
import ecole.gestionecole.entites.*;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {
    
    static Mapper INSTANCE = Mappers.getMapper(Mapper.class);

    AdminDTO toAdminDTO(Admin admin);
    Admin toAdmin(AdminDTO adminDTO);

    ClassDTO toClassesDTO(Classes classes);
    Classes toClasses(ClassDTO classesDTO);

    NoteDTO toNoteDTO(Note note);
    Note toNote(NoteDTO noteDTO);

    ProfessorClassDTO toProfessorClassDTO(ProfessorClass professorClass);
    ProfessorClass toProfessorClass(ProfessorClassDTO dto);

    @Mapping(source = "classEntity.id", target = "classId")
    @Mapping(source = "classEntity.name", target = "classeName") // LA LIGNE MAGIQUE
    StudentDTO toStudentDTO(Student student);

    @Mapping(source = "classId", target = "classEntity.id")
    Student toStudent(StudentDTO dto);

    SubjectDTO toSubjectDTO(Subject subject);
    Subject toSubject(SubjectDTO dto);

    @Mapping(source = "subject.id", target = "subjectId")
    @Mapping(source = "subject.name", target = "subjectName") // LA LIGNE MAGIQUE
    TeacherDTO toTeacherDTO(Teacher teacher);

    @Mapping(source = "subjectId", target = "subject.id")
    Teacher toTeacher(TeacherDTO dto);
}
