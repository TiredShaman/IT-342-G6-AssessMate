package edu.cit.AssessMate.Service;

import edu.cit.AssessMate.Entity.QuizAttempt;
import edu.cit.AssessMate.Repository.QuizAttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizAttemptService {
    private final QuizAttemptRepository quizAttemptRepository;

    @Autowired
    public QuizAttemptService(QuizAttemptRepository quizAttemptRepository) {
        this.quizAttemptRepository = quizAttemptRepository;
    }

    public List<QuizAttempt> findByQuizId(String quizID) {
        return quizAttemptRepository.findByQuizQuizID(quizID);
    }

    public List<QuizAttempt> findByRevieweeId(String revieweeID) {
        return quizAttemptRepository.findByRevieweeRevieweeID(revieweeID);
    }

    public QuizAttempt save(QuizAttempt quizAttempt) {
        return quizAttemptRepository.save(quizAttempt);
    }

    public void deleteById(String quizAttemptID) {
        quizAttemptRepository.deleteById(quizAttemptID);
    }
}
