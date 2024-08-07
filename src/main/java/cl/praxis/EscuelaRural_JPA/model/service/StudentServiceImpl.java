package cl.praxis.EscuelaRural_JPA.model.service;

import cl.praxis.EscuelaRural_JPA.model.entity.Student;
import cl.praxis.EscuelaRural_JPA.model.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    StudentRepository repository;
    CourseServiceImpl courseService;

    public StudentServiceImpl(StudentRepository repository, CourseServiceImpl courseService) {
        this.repository = repository;
        this.courseService = courseService;
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Student findOne(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean create(Student s) {
        Student student = repository.save(s);
        System.out.println("Creado el id " + student.getId());

        return student != null;
    }

    @Override
    public boolean update(Student s) {
        Student student = repository.save(s);
        return student != null;
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
