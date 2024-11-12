package ru.hogwarts.school;

import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

public class TestConstants {
    public static final Faculty TEST_FACULTY = new Faculty(1L, "Gryffindor", "Red");

    public static final Faculty TEST_FACULTY_2 = new Faculty(2L, "Hufflepuff", "Green");

    public static final Student TEST_STUDENT = new Student(1L, "Harry", 17);

    public static final Student TEST_STUDENT_2 = new Student(2L, "Ron", 16);
}
