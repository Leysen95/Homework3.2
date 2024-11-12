package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

@PostMapping("/add")
    public long add(@RequestBody Faculty faculty) {
        return facultyService.add(faculty);
    }

    @PutMapping("/{id}/update")
    public Faculty update(@PathVariable("id") long id,
                          @RequestBody Faculty faculty){
        return facultyService.update(id, faculty);
    }

    @DeleteMapping("/{id}/remove")
    public Faculty deleteById(@PathVariable("id") long id){
        return facultyService.deleteById(id);
    }

    @GetMapping("/{id}/get")
    public Faculty findById(@PathVariable("id") long id){
        return facultyService.findById(id);
    }

    @GetMapping("/get/all")
    public Collection<Faculty> findAll(){
        return facultyService.findAll();
    }

    @GetMapping("/get/by-color")
    public Collection<Faculty> findByColor(@RequestParam("color") String color){
        return facultyService.findByColor(color);
    }
}
