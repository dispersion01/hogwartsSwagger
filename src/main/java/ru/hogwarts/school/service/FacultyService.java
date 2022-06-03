package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.FacultyRepository;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    Logger logger = LoggerFactory.getLogger(FacultyService.class);
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }


    public Faculty createFaculty(Faculty faculty) {
        logger.info("Was invoked method for create faculty");
        return facultyRepository.save(faculty);
    }

    public Optional<Faculty> readFaculty(long id) {
        logger.info("Was invoked method for read faculty");
        return facultyRepository.findById(id);
    }

    public Faculty editFaculty(Faculty faculty) {
        logger.info("Was invoked method for edit faculty");
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        logger.info("Was invoked method for delete faculty");
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> colorFaculty(String color) {
        logger.info("Was invoked method get faculty by color");
        return facultyRepository.findAll();
    }
    public Collection<Faculty> findByColorOrNameIgnoreCase(String color, String name) {
        logger.info("Was invoked method of get faculty by color or name");
      return   facultyRepository.findByColorOrNameIgnoreCase(color, name);
    }

    public Optional<String> getFacultyLongName() {
        return  facultyRepository.findAll().stream().parallel()
                .map(Faculty::getName)
                .max(Comparator.comparing(String::length));

    }
}
