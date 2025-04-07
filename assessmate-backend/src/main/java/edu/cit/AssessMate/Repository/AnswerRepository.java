package edu.cit.AssessMate.Repository;

import edu.cit.AssessMate.Entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, String> {
    List<Answer> findByQuizAttemptQuizAttemptID(String quizAttemptID);
    List<Answer> findByQuestionQuestionID(String questionID);
    List<Answer> findByQuizQuizID(String quizID);
}