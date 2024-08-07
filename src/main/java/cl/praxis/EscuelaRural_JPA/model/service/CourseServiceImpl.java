package cl.praxis.EscuelaRural_JPA.model.service;

import cl.praxis.EscuelaRural_JPA.model.entity.Course;
import cl.praxis.EscuelaRural_JPA.model.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    CourseRepository repository;

    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Course> findAll() {
        return repository.findAll();
    }

    @Override
    public Course findOne(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean create(Course sj) {
        Course course = repository.save(sj);
        System.out.println("creado el id " + course.getId());

        return course != null;
    }

    @Override
    public boolean update(Course sj) {
        Course course = repository.save(sj);
        return course != null;
    }

    @Override
    public boolean delete(int id) {
        boolean exist = repository.existsById(id);
        if (exist){
            repository.deleteById(id);
        }
        return exist;
    }
}
