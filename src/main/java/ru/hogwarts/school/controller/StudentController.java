package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {


        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("{id}")
    public Optional<Student> getStudent(@PathVariable Long id) {
        return studentService.readStudent(id);
    }

    @PutMapping
    public Student editStudent(@RequestBody Student student) {
        return studentService.editStudent(student);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping({"studentage/{age}"})
    public Collection<Student> ageStudent(@PathVariable int age) {
        return studentService.ageStudent(age);
    }

    @GetMapping(params = {"min", "max"})
    public Collection<Student> findByAgeBetween(@RequestParam Integer min,
                                                @RequestParam Integer max
    ) {
        return studentService.findByAgeBetween(min, max);
    }

    @GetMapping({"getStudentNameA"})
    public List<String> getStudentNameA() {
        return studentService.getStudentNameA();
    }
    @GetMapping({"getStudentAverageAge"})
    public OptionalDouble getStudentAverageAge() {
        return studentService.getStudentAverageAge();
    }

    @GetMapping({"printAllStudent"})
    public void printAllStudentParallelMethod() {
        studentService.printAllStudentParallelMethod();
    }

    @GetMapping({"printAllStudentSyncMethod"})
    public void printAllStudentSyncMethod() {
         studentService.printAllStudentSyncMethod();
    }
}
