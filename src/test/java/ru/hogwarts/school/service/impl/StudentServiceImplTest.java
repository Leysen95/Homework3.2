package ru.hogwarts.school.service.impl;

import org.junit.jupiter.api.Test;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static ru.hogwarts.school.TestConstants.TEST_STUDENT;
import static ru.hogwarts.school.TestConstants.TEST_STUDENT_2;

class StudentServiceImplTest {

    private final StudentServiceImpl studentService = new StudentServiceImpl();

    @Test
    void add() {
        long expected = studentService.add(TEST_STUDENT);
        assertThat(expected).isOne();
        Student actual = studentService.findById(expected);
        assertThat(actual).isEqualTo(TEST_STUDENT);
    }

    @Test
    void update() {
        long targetId = TEST_STUDENT.getId();
        studentService.add(TEST_STUDENT);

        Student oldStudent = studentService.update(targetId, TEST_STUDENT_2);

        assertThat(oldStudent).isEqualTo(TEST_STUDENT);
        Student actual = studentService.findById(targetId);
        assertThat(actual).isEqualTo(TEST_STUDENT_2);
    }

    @Test
    void deleteById() {
        long targetId = TEST_STUDENT.getId();
        studentService.add(TEST_STUDENT);

        Student deletedStudent = studentService.deleteById(targetId);

        assertThat(deletedStudent).isEqualTo(TEST_STUDENT);
        Student actual = studentService.findById(targetId);
        assertThat(actual).isNull();
    }

    @Test
    void findById() {
        long targetId = TEST_STUDENT.getId();
        studentService.add(TEST_STUDENT);

        Student actual = studentService.findById(targetId);

        assertThat(actual).isEqualTo(TEST_STUDENT);
    }

    @Test
    void findAll() {
        studentService.add(TEST_STUDENT);
        studentService.add(TEST_STUDENT_2);
        List<Student> expected = List.of(TEST_STUDENT, TEST_STUDENT_2);

        Collection<Student> actual = studentService.findAll();

        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void findByAge() {
        studentService.add(TEST_STUDENT);

        Collection<Student> actual = studentService.findByAge(TEST_STUDENT.getAge());

        assertThat(actual).containsExactly(TEST_STUDENT);
    }
}