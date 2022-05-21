package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.GetMapping;
import ru.hogwarts.school.interfaces.StudentsById;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

public class GetStudentByIdController {
    private final StudentService studentService;

    public GetStudentByIdController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/get-student-amount")
    public Collection<StudentsById> getStudentByIdAmount() {
        return studentService.getStudentAmount();
    }

    @GetMapping("/get-average-age")
    public Collection<StudentsById> getAverageAgeStudent() {
        return studentService.getAverageAgeStudent();
    }

    @GetMapping("get-five-student")
    public Collection<StudentsById> getFiveLastStudent() {
        return studentService.getFiveLastStudent();
    }
}
