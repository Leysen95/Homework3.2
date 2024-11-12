package ru.hogwarts.school.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.model.exception.StudentNotFoundException;
import ru.hogwarts.school.service.StudentService;


import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.unmodifiableCollection;

@Service
public class StudentServiceImpl implements StudentService {

    private final Map<Long, Student> repository = new HashMap<>();

    private long counter = 0;

    @Override
    public long add(Student student) {
        student.setId(++counter);
        repository.put(counter, student);
        return counter;
    }

    @Override
    public Student update(long id, Student student) {
        checkStudentExist(id);
        student.setId(id);
        return repository.put(id, student);
    }

    @Override
    public Student deleteById(long id) {
        checkStudentExist(id);
        return repository.remove(id);
    }

    @Override
    public Student findById(long id) {
        return repository.get(id);
    }

    @Override
    public Collection<Student> findAll() {
        return unmodifiableCollection(repository.values());
    }

    @Override
    public Collection<Student> findByAge(int age){
        return repository.values().stream()
                .filter(st -> st.getAge() == age)
                .toList();
    }

    private void checkStudentExist(long id) {
        if (!repository.containsKey(id)) {
            throw new StudentNotFoundException(id);
        }
    }
}
