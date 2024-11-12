package ru.hogwarts.school.service;

import org.springframework.web.bind.annotation.RequestParam;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;

public interface FacultyService {
    long add(Faculty faculty);

    Faculty update(long id, Faculty faculty);

    Faculty deleteById(long id);

    Faculty findById(long id);

    Collection<Faculty> findAll();

    Collection<Faculty> findByColor(String color);
}
