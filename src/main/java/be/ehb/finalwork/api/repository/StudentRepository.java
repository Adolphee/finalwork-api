package be.ehb.finalwork.api.repository;

import be.ehb.finalwork.api.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Long> {
    Iterable<Student> findAllByIsTeacherIsFalse();
    Iterable<Student> findAllByUsernameContaining(String query);
    Optional<Student> findDistinctFirstByEmailEqualsAndPasswordEquals(String email, String password);
}
