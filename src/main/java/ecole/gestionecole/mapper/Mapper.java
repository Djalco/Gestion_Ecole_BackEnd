package ecole.gestionecole.mapper;

import org.mapstruct.factory.Mappers;

import ecole.gestionecole.DTO.*;
import ecole.gestionecole.entites.*;

@org.mapstruct.Mapper
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

    StudentDTO toStudentDTO(Student student);
    Student toStudent(StudentDTO dto);

    SubjectDTO toSubjectDTO(Subject subject);
    Subject toSubject(SubjectDTO dto);

    TeacherDTO toTeacherDTO(Teacher teacher);
    Teacher toTeacher(TeacherDTO dto);
}
