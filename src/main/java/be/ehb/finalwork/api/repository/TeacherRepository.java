package be.ehb.finalwork.api.repository;

import be.ehb.finalwork.api.model.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
    public Iterable<Teacher> findAllByIsTeacherIsTrue();
}
