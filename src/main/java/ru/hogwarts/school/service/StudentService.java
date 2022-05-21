package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.interfaces.StudentsById;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.Collection;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
       return studentRepository.save(student);
    }

    public Optional<Student> readStudent(long id) {
        return studentRepository.findById(id);
    }

    public Student editStudent(Student student) {

        return studentRepository.save(student);
    }
    public void deleteStudent(long id) {
       studentRepository.deleteById(id);
    }

    public Collection<Student> ageStudent(int age) {


        return studentRepository.findAll();
    }

    public Collection<Student> findByAgeBetween(Integer min, Integer max){
        return studentRepository.findByAgeBetween(min, max);
    }
    public Collection<StudentsById> getStudentAmount() {
        return studentRepository.getStudentById();
    }
    public  Collection<StudentsById> getAverageAgeStudent() {
        return studentRepository.getAverageAgeStudent();
    }
    public  Collection<StudentsById> getFiveLastStudent() {
        return studentRepository.getFiveLastStudent();
    }

}
