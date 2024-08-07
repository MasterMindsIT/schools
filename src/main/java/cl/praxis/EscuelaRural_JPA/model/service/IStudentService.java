package cl.praxis.EscuelaRural_JPA.model.service;

import cl.praxis.EscuelaRural_JPA.model.entity.Student;

import java.util.List;

public interface IStudentService {

    List<Student> findAll();
    Student findOne(int id);
    boolean create(Student s);
    boolean update(Student s);
    boolean delete(int id);
}
