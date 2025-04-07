package edu.cit.AssessMate.Repository;

import edu.cit.AssessMate.Entity.QuizAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizAttemptRepository extends JpaRepository<QuizAttempt, String> {
    List<QuizAttempt> findByQuizQuizID(String quizID);
    List<QuizAttempt> findByRevieweeRevieweeID(String revieweeID);
}