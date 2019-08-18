package be.ehb.finalwork.api.repository;

import be.ehb.finalwork.api.model.Student;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


@JsonInclude(JsonInclude.Include.NON_NULL)
public interface StudentRepository extends CrudRepository<Student, Long> {
    Iterable<Student> findAllByIsTeacherIsFalse();
    Iterable<Student> findAllByUsernameContaining(String query);
    Optional<Student> findDistinctFirstByEmailEqualsAndPasswordEquals(String email, String password);
}
