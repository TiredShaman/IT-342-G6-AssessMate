package edu.cit.AssessMate.Service;

import edu.cit.AssessMate.Entity.Quiz;
import edu.cit.AssessMate.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    private final QuizRepository quizRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public List<Quiz> findAll() {
        return quizRepository.findAll();
    }

    public Optional<Quiz> findById(String quizID) {
        return quizRepository.findById(quizID);
    }

    public List<Quiz> findByClassId(String classID) {
        return quizRepository.findByClassEntityClassID(classID);
    }

    public Quiz save(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public void deleteById(String quizID) {
        quizRepository.deleteById(quizID);
    }
}