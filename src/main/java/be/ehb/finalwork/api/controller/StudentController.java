package be.ehb.finalwork.api.controller;

import be.ehb.finalwork.api.exception.StudentNotFoundException;
import be.ehb.finalwork.api.model.LoginForm;
import be.ehb.finalwork.api.model.Student;
import be.ehb.finalwork.api.repository.StudentRepository;
import javassist.NotFoundException;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeEditor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.awt.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@Validated
public class StudentController {
    @Autowired
    private StudentRepository repository;

    @PostMapping(value = {"/auth"})
    public Student authenticate(@Valid @RequestBody LoginForm form) throws StudentNotFoundException{
        Optional<Student> student = repository.findDistinctFirstByEmailEqualsAndPasswordEquals(form.getEmail(), form.getPassword());
        if(student.isPresent()){
            return student.get();
        }
        throw new StudentNotFoundException();
    }

    @GetMapping(value = {"", "/"})
    public Iterable<Student> getAll(){
        return repository.findAllByIsTeacherIsFalse();
    }

    @GetMapping(value = {"/search/{query}"})
    public Iterable<Student> search(@PathVariable @NotNull String query){
        return repository.findAllByUsernameContaining(query);
    }

    @GetMapping(value = "/{id}")
    @NotFound
    public Student getById(@PathVariable Long id) throws StudentNotFoundException{
        Optional<Student> student = repository.findById(id);
        if(student.isPresent()){
            return student.get();
        } else {
            throw new StudentNotFoundException();
        }
    }

    @PostMapping(value = {"","/"})
    public Student create(@Valid @RequestBody Student student){
        return repository.save(student);
    }

    @PutMapping(value = "/{id}")
    @NotFound
    public Student update(@NotNull @PathVariable Long id,@RequestBody Student student) throws StudentNotFoundException{
        Optional<Student> s = repository.findById(id);
        if(s.isPresent()){
            student.setId(id);
            return repository.save(student);
        } else {
            throw new StudentNotFoundException();
        }
    }

    @DeleteMapping(value = "/{id}")
    @NotFound
    public void delete(@NotNull @PathVariable Long id) throws StudentNotFoundException{
        Optional<Student> s = repository.findById(id);
        if(s.isPresent()){
            repository.deleteById(id);
        } else {
            throw new StudentNotFoundException();
        }
    }
}
