package ru.hogwarts.school.service.impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.model.exception.FacultyNotFoundException;
import ru.hogwarts.school.service.FacultyService;


import java.util.*;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final Map<Long, Faculty> repository = new HashMap<>();

    private long counter = 0;

    @Override
    public long add(Faculty faculty) {
        faculty.setId(++counter);
        repository.put(counter, faculty);
        return counter;
    }

    @Override
    public Faculty update(long id, Faculty faculty) {
        checkFacultyExist(id);
        faculty.setId(id);
        return repository.put(id, faculty);
    }

    @Override
    public Faculty deleteById(long id) {
        checkFacultyExist(id);
        return repository.remove(id);
    }

    @Override
    public Faculty findById(long id) {
        return repository.get(id);
    }

    @Override
    public Collection<Faculty> findAll() {
        return Collections.unmodifiableCollection(repository.values());
    }

    @Override
    public Collection<Faculty> findByColor(String color){
        return repository.values().stream()
                .filter(f -> Objects.equals(f.getColor(), color))
                .toList();
    }

    private void checkFacultyExist(long id) {
        if (!repository.containsKey(id)) {
            throw new FacultyNotFoundException(id);
        }
    }
}
