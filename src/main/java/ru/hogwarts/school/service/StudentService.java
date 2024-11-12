package ru.hogwarts.school.service;

import org.springframework.web.bind.annotation.RequestParam;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.impl.StudentServiceImpl;

import java.util.Collection;

public interface StudentService {
    long add(Student faculty);

    Student update(long id, Student faculty);

    Student deleteById(long id);

    Student findById(long id);

    Collection<Student> findAll();

    Collection<Student> findByAge(int age);
}
