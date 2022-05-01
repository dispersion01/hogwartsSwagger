package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService facultyService;


    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @GetMapping({"{id}"})
    public Faculty getFaculty(@PathVariable Long id) {
        return facultyService.readFaculty(id);
    }

    @PutMapping
    public Faculty editFaculty(@RequestBody Faculty faculty) {
        return facultyService.editFaculty(faculty);
    }

    @DeleteMapping({"{id}"})
    public Faculty deleteFaculty(@PathVariable Long id) {
        return facultyService.deleteFaculty(id);
    }

    @GetMapping({"facultycolor/{color}"})
    public Collection <Faculty> colorFaculty(@PathVariable String color) {
        return facultyService.colorFaculty(color);
    }
}

