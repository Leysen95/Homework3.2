package ru.hogwarts.school.service.impl;

import org.junit.jupiter.api.Test;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static ru.hogwarts.school.TestConstants.TEST_FACULTY;
import static ru.hogwarts.school.TestConstants.TEST_FACULTY_2;

class FacultyServiceImplTest {

    private final FacultyServiceImpl facultyService = new FacultyServiceImpl();

    @Test
    void add() {
        long expected = facultyService.add(TEST_FACULTY);
        assertThat(expected).isOne();
        Faculty actual = facultyService.findById(expected);
        assertThat(actual).isEqualTo(TEST_FACULTY);
    }

    @Test
    void update() {
        long targetId = TEST_FACULTY.getId();
        facultyService.add(TEST_FACULTY);

        Faculty oldFaculty = facultyService.update(targetId, TEST_FACULTY_2);

        assertThat(oldFaculty).isEqualTo(TEST_FACULTY);
        Faculty actual = facultyService.findById(targetId);
        assertThat(actual).isEqualTo(TEST_FACULTY_2);
    }

    @Test
    void deleteById() {
        long targetId = TEST_FACULTY.getId();
        facultyService.add(TEST_FACULTY);

        Faculty deletedFaculty = facultyService.deleteById(targetId);

        assertThat(deletedFaculty).isEqualTo(TEST_FACULTY);
        Faculty actual = facultyService.findById(targetId);
        assertThat(actual).isNull();
    }

    @Test
    void findById() {
        long targetId = TEST_FACULTY.getId();
        facultyService.add(TEST_FACULTY);

        Faculty actual = facultyService.findById(targetId);

        assertThat(actual).isEqualTo(TEST_FACULTY);
    }

    @Test
    void findAll() {
        facultyService.add(TEST_FACULTY);
        facultyService.add(TEST_FACULTY_2);
        List<Faculty> expected = List.of(TEST_FACULTY, TEST_FACULTY_2);

        Collection<Faculty> actual = facultyService.findAll();

        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void findByColor() {
        facultyService.add(TEST_FACULTY);

        Collection<Faculty> actual = facultyService.findByColor(TEST_FACULTY.getColor());

        assertThat(actual).containsExactly(TEST_FACULTY);
    }
}