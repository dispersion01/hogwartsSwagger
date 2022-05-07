package ru.hogwarts.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Student;

import javax.persistence.criteria.CriteriaBuilder;
import java.net.CookieHandler;
import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> findByAgeBetween(Integer min, Integer max);

    Collection<Student> findByAge(Integer age);



}
