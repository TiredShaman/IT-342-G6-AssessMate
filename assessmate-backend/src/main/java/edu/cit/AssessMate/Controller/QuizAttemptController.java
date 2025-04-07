package edu.cit.AssessMate.Controller;

import edu.cit.AssessMate.Entity.QuizAttempt;
import edu.cit.AssessMate.Service.QuizAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz-attempts")
public class QuizAttemptController {
    private final QuizAttemptService quizAttemptService;

    @Autowired
    public QuizAttemptController(QuizAttemptService quizAttemptService) {
        this.quizAttemptService = quizAttemptService;
    }

    @GetMapping("/quiz/{quizId}")
    public List<QuizAttempt> getAttemptsByQuizId(@PathVariable String quizId) {
        return quizAttemptService.findByQuizId(quizId);
    }

    @GetMapping("/reviewee/{revieweeId}")
    public List<QuizAttempt> getAttemptsByRevieweeId(@PathVariable String revieweeId) {
        return quizAttemptService.findByRevieweeId(revieweeId);
    }

    @PostMapping
    public QuizAttempt createQuizAttempt(@RequestBody QuizAttempt quizAttempt) {
        return quizAttemptService.save(quizAttempt);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuizAttempt(@PathVariable String id) {
        quizAttemptService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
