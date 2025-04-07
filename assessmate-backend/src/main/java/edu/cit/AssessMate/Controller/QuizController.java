package edu.cit.AssessMate.Controller;

import edu.cit.AssessMate.Entity.Quiz;
import edu.cit.AssessMate.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {
    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public List<Quiz> getAllQuizzes() {
        return quizService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable String id) {
        Optional<Quiz> quiz = quizService.findById(id);
        return quiz.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/class/{classId}")
    public List<Quiz> getQuizzesByClassId(@PathVariable String classId) {
        return quizService.findByClassId(classId);
    }

    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizService.save(quiz);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable String id, @RequestBody Quiz quizDetails) {
        Optional<Quiz> optionalQuiz = quizService.findById(id);
        if (optionalQuiz.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Quiz quiz = optionalQuiz.get();
        quiz.setQuizTitle(quizDetails.getQuizTitle());
        quiz.setTimeLimit(quizDetails.getTimeLimit());
        quiz.setClassEntity(quizDetails.getClassEntity());
        Quiz updatedQuiz = quizService.save(quiz);
        return ResponseEntity.ok(updatedQuiz);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable String id) {
        if (quizService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        quizService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}