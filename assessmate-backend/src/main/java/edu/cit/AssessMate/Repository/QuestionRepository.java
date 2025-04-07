package edu.cit.AssessMate.Repository;

import edu.cit.AssessMate.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {
    List<Question> findByQuizQuizID(String quizID);
}
