package be.ehb.finalwork.api.repository;

import be.ehb.finalwork.api.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuizRepository extends CrudRepository<Question, Long> {
    Iterable<Question> findAllByCourse_Id(Long course_id);
}
