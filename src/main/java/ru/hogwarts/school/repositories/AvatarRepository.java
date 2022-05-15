package ru.hogwarts.school.repositories;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.model.Student;

import java.util.Optional;

public interface AvatarRepository extends JpaRepository<Avatar,Long> {
    Avatar findByStudentId(Long id);
}
