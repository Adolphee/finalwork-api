package be.ehb.finalwork.api.repository;

import be.ehb.finalwork.api.model.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuizRepository extends CrudRepository<Question, Long> {
    List<Question> findAllByCourse_Id(Long course_id);
}
