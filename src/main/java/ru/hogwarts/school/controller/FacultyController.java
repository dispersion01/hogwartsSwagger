package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
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
    public ResponseEntity deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping({"facultycolor/{color}"})
    public Collection<Faculty> colorFaculty(@PathVariable String color) {
        return facultyService.colorFaculty(color);
    }

    @GetMapping(params = {"color", "name"})
    public Collection<Faculty> findByAgeBetween(@RequestParam String color,
                                                @RequestParam String name
    ) {
        return facultyService.findByColorOrNameIgnoreCase(color, name);
    }
}

