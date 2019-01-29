package be.ehb.finalwork.api.repository;

import be.ehb.finalwork.api.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
    public Iterable<Student> findAllByIsTeacherIsFalse();
    public Iterable<Student> findAllByUsernameContaining(String query);
}
