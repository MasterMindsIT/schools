package cl.praxis.EscuelaRural_JPA.model.repository;

import cl.praxis.EscuelaRural_JPA.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
