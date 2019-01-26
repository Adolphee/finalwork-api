package be.ehb.finalwork.api.controller;

import be.ehb.finalwork.api.exception.TeacherNotFoundException;
import be.ehb.finalwork.api.model.Teacher;
import be.ehb.finalwork.api.repository.TeacherRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
@Validated
public class TeacherController {
    @Autowired
    private TeacherRepository repository;

    @GetMapping(value = {"", "/"})
    public Iterable<Teacher> getAll(){
        return repository.findAllByIsTeacherIsTrue();
    }

    @GetMapping(value = "/{id}")
    @NotFound
    public Teacher getById(@PathVariable Long id) throws TeacherNotFoundException {
        Optional<Teacher> teacher = repository.findById(id);
        if(teacher.isPresent()){
            return teacher.get();
        } else {
            throw new TeacherNotFoundException();
        }
    }

    @PostMapping(value = {"","/"})
    public Teacher create(@Valid @RequestBody Teacher teacher){
        return repository.save(teacher);
    }

    @PutMapping(value = "/{id}")
    @NotFound
    public Teacher update(@NotNull @PathVariable Long id, @Valid @RequestBody Teacher teacher) throws TeacherNotFoundException{
        Optional<Teacher> s = repository.findById(id);
        if(s.isPresent()){
            teacher.setId(id);
            return repository.save(teacher);
        } else {
            throw new TeacherNotFoundException();
        }
    }

    @DeleteMapping(value = "/{id}")
    @NotFound
    public void delete(@NotNull @PathVariable Long id) throws TeacherNotFoundException{
        Optional<Teacher> s = repository.findById(id);
        if(s.isPresent()){
            repository.deleteById(id);
        } else {
            throw new TeacherNotFoundException();
        }
    }
}
