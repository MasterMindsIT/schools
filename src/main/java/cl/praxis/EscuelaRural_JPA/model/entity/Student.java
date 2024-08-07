package cl.praxis.EscuelaRural_JPA.model.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "student")
@Setter
@Getter
@EqualsAndHashCode(exclude = {"courses"})
@ToString(exclude = {"courses"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_id")
    private int id;
    private String name;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL )
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name="student_id", referencedColumnName = "student_id"),
            inverseJoinColumns = @JoinColumn(name="course_id", referencedColumnName = "course_id")
    )
    private Set<Course> courses;

}
