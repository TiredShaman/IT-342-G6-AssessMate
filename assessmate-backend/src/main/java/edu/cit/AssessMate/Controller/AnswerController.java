package edu.cit.AssessMate.Controller;

import edu.cit.AssessMate.Entity.Answer;
import edu.cit.AssessMate.Service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {
    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/attempt/{quizAttemptId}")
    public List<Answer> getAnswersByQuizAttemptId(@PathVariable String quizAttemptId) {
        return answerService.findByQuizAttemptId(quizAttemptId);
    }

    @GetMapping("/question/{questionId}")
    public List<Answer> getAnswersByQuestionId(@PathVariable String questionId) {
        return answerService.findByQuestionId(questionId);
    }

    @GetMapping("/quiz/{quizId}")
    public List<Answer> getAnswersByQuizId(@PathVariable String quizId) {
        return answerService.findByQuizId(quizId);
    }

    @PostMapping
    public Answer createAnswer(@RequestBody Answer answer) {
        return answerService.save(answer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable String id) {
        answerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}