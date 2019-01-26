package be.ehb.finalwork.api.repository;

import be.ehb.finalwork.api.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
