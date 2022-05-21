package ru.hogwarts.school.interfaces;

import ru.hogwarts.school.model.Student;

public interface StudentsById {
    Integer getStudentAmountById();

    Integer getAverageAgeStudent();

    Student getFiveLastStudent();
}
