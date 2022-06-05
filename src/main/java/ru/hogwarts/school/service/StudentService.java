package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.interfaces.StudentsById;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.DoubleStream.iterate;

@Service
public class StudentService {

    @Value("${hogwarts-school-service.url}")
    private String url;

    @Value("${hogwarts-school-service.api-key}")
    private String apiKey;

    Logger logger = LoggerFactory.getLogger(StudentService.class);
    private final StudentRepository studentRepository;
    private final StudentService studentService;

    public StudentService(StudentRepository studentRepository, StudentService studentService) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }


    public Student createStudent(Student student) {
        logger.info("Was invoked method for create student");
        return studentRepository.save(student);
    }

    public Optional<Student> readStudent(long id) {
        logger.info("Was invoked method for read student");
        return studentRepository.findById(id);
    }

    public Student editStudent(Student student) {
        logger.info("Was invoked method for edit student");
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> ageStudent(int age) {

        logger.info("Was invoked method get all student");
        return studentRepository.findAll();
    }

    public Collection<Student> findByAgeBetween(Integer min, Integer max) {
        logger.info("Was invoked method find student between min and max age");
        return studentRepository.findByAgeBetween(min, max);
    }

    public Collection<StudentsById> getStudentAmount() {
        logger.info("Was invoked method for get amount student");
        return studentRepository.getStudentById();
    }

    public Collection<StudentsById> getAverageAgeStudent() {
        logger.info("Was invoked method for get average student");
        return studentRepository.getAverageAgeStudent();
    }

    public Collection<StudentsById> getFiveLastStudent() {
        logger.info("Was invoked method for get five last student");
        return studentRepository.getFiveLastStudent();
    }

    public List<String> getStudentNameA() {
        return studentRepository.findAll().stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .filter(studentRepository -> studentRepository.startsWith("A"))
                .sorted()
                .collect(Collectors.toList());


    }

    public OptionalDouble getStudentAverageAge() {
        return studentRepository.findAll().stream()
                .mapToInt(student -> student.getAge())
                .average();
    }

    public Integer getIntegerNumber() {
        int sum = Stream
                .iterate(1, a -> a + 1)
                .limit(1_000_000)
                .reduce(0, (a, b) -> a + b);
        return sum;
    }

    public void doName(int number) {
        System.out.println(studentRepository.findAll() + " " + number);

    }

    public void printAllStudentParallelMethod() {
        studentService.doName(1);
        studentService.doName(2);
        new Thread(() -> {
            studentService.doName(3);
            studentService.doName(4);
        }).run();
        studentService.doName(5);
        studentService.doName(6);
    }
/*    public void  printAllStudentParallelMethod() {
        System.out.println(studentRepository.findAll());
        new Thread(() ->{
            System.out.println(studentRepository.findAll());
        }).run();
        }*/


    public synchronized void printAllStudentSyncMethod() {
        studentService.doName(1);
        studentService.doName(2);
        new Thread(() -> {
            studentService.doName(3);
            studentService.doName(4);
        }).run();
        studentService.doName(5);
        studentService.doName(6);
    }

}

