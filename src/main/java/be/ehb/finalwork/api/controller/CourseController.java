package be.ehb.finalwork.api.controller;


import be.ehb.finalwork.api.exception.CourseNotFoundException;
import be.ehb.finalwork.api.model.Course;
import be.ehb.finalwork.api.repository.CourseRepository;
import javassist.NotFoundException;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
@Validated
public class CourseController {
    @Autowired
    private CourseRepository repository;

    @GetMapping(value = {"", "/"})
    public Iterable<Course> getAll(){
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    @NotFound
    public Course getById(@PathVariable Long id) throws CourseNotFoundException {
        Optional<Course> course = repository.findById(id);
        if(course.isPresent()){
            return course.get();
        } else {
            throw new CourseNotFoundException();
        }
    }

    @PostMapping(value = {"","/"})
    public Course create(@Valid @RequestBody Course course){
        return repository.save(course);
    }

    @PutMapping(value = "/{id}")
    @NotFound
    public Course update(@NotNull @PathVariable Long id, @Valid @RequestBody Course course) throws CourseNotFoundException{
        Optional<Course> s = repository.findById(id);
        if(s.isPresent()){
            course.setId(id);
            return repository.save(course);
        } else {
            throw new CourseNotFoundException();
        }
    }

    @DeleteMapping(value = "/{id}")
    @NotFound
    public void delete(@NotNull @PathVariable Long id) throws CourseNotFoundException {
        Optional<Course> s = repository.findById(id);
        if(s.isPresent()){
            repository.deleteById(id);
        } else {
            throw new CourseNotFoundException();
        }
    }
}
