package edu.cit.AssessMate.Service;

import edu.cit.AssessMate.Entity.Answer;
import edu.cit.AssessMate.Repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> findByQuizAttemptId(String quizAttemptID) {
        return answerRepository.findByQuizAttemptQuizAttemptID(quizAttemptID);
    }

    public List<Answer> findByQuestionId(String questionID) {
        return answerRepository.findByQuestionQuestionID(questionID);
    }

    public List<Answer> findByQuizId(String quizID) {
        return answerRepository.findByQuizQuizID(quizID);
    }

    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }

    public void deleteById(String answerID) {
        answerRepository.deleteById(answerID);
    }
}