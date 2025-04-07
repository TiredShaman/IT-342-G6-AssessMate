package edu.cit.AssessMate.Controller;

import edu.cit.AssessMate.Entity.Question;
import edu.cit.AssessMate.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable String id) {
        Optional<Question> question = questionService.findById(id);
        return question.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsByQuizId(@PathVariable String quizId) {
        return questionService.findByQuizId(quizId);
    }

    @PostMapping
    public Question createQuestion(@RequestBody Question question) {
        return questionService.save(question);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable String id, @RequestBody Question questionDetails) {
        Optional<Question> optionalQuestion = questionService.findById(id);
        if (optionalQuestion.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Question question = optionalQuestion.get();
        question.setQuestionText(questionDetails.getQuestionText());
        question.setQuestionType(questionDetails.getQuestionType());
        question.setQuiz(questionDetails.getQuiz());
        Question updatedQuestion = questionService.save(question);
        return ResponseEntity.ok(updatedQuestion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable String id) {
        if (questionService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        questionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
