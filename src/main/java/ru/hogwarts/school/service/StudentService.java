package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
       return studentRepository.save(student);
    }

    public Student readStudent(long id) {
        return studentRepository.getById(id);
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
}
