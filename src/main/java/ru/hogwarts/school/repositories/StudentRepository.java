package ru.hogwarts.school.repositories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.interfaces.StudentsById;
import ru.hogwarts.school.model.Student;

import javax.persistence.criteria.CriteriaBuilder;
import java.net.CookieHandler;
import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> findByAgeBetween(Integer min, Integer max);

    Collection<Student> findByAge(Integer age);

    @Query(value = "select COUNT(name)  as amount_student from student", nativeQuery = true)
    Collection<StudentsById> getStudentById();

    @Query(value = "select avg(age) as average_age from student ", nativeQuery = true)
    Collection<StudentsById> getAverageAgeStudent();

    @Query(value = "select name, age from student offset 5 limit 5 ", nativeQuery = true)
    Collection<StudentsById> getFiveLastStudent();



}
