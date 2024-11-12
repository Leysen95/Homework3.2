package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public long add(@RequestBody Student student){
        return studentService.add(student);
    }

    @PutMapping("/{id}/update")
    public Student update(@PathVariable ("id") long id,
                          @RequestBody Student student){
        return studentService.update(id, student);
    }

    @DeleteMapping("/{id}/remove")
    public Student deleteById(@PathVariable("id") long id){
        return studentService.deleteById(id);
    }

    @GetMapping("/{id}/get")
    public Student findById(@PathVariable("id") long id){
        return studentService.findById(id);
    }

    @GetMapping("/get/all")
    public Collection<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/get/by-age")
    public Collection<Student> findByAge(@RequestParam("age") int age){
        return studentService.findByAge(age);
    }
}
