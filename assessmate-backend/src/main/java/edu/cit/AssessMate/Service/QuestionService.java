package edu.cit.AssessMate.Service;

import edu.cit.AssessMate.Entity.Question;
import edu.cit.AssessMate.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public Optional<Question> findById(String questionID) {
        return questionRepository.findById(questionID);
    }

    public List<Question> findByQuizId(String quizID) {
        return questionRepository.findByQuizQuizID(quizID);
    }

    public Question save(Question question) {
        return questionRepository.save(question);
    }

    public void deleteById(String questionID) {
        questionRepository.deleteById(questionID);
    }
}