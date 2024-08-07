package cl.praxis.EscuelaRural_JPA.model.service;

import cl.praxis.EscuelaRural_JPA.model.entity.Course;

import java.util.List;

public interface ICourseService {

    List<Course> findAll();
    Course findOne(int id);
    boolean create(Course sj);
    boolean update(Course sj);
    boolean delete(int id);
}
