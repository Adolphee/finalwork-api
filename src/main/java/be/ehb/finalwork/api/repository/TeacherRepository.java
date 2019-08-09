package be.ehb.finalwork.api.repository;

import be.ehb.finalwork.api.model.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
    Iterable<Teacher> findAllByIsTeacherIsTrue();
    Optional<Teacher> findDistinctFirstByEmailEqualsAndPasswordEquals(String email, String password);
}
