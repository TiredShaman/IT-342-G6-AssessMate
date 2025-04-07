package edu.cit.AssessMate.Controller;

import edu.cit.AssessMate.Entity.Choice;
import edu.cit.AssessMate.Service.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/choices")
public class ChoiceController {
    private final ChoiceService choiceService;

    @Autowired
    public ChoiceController(ChoiceService choiceService) {
        this.choiceService = choiceService;
    }

    @GetMapping("/question/{questionId}")
    public List<Choice> getChoicesByQuestionId(@PathVariable String questionId) {
        return choiceService.findByQuestionId(questionId);
    }

    @GetMapping("/question/{questionId}/correct")
    public List<Choice> getCorrectChoicesByQuestionId(@PathVariable String questionId) {
        return choiceService.findCorrectChoicesByQuestionId(questionId);
    }

    @PostMapping
    public Choice createChoice(@RequestBody Choice choice) {
        return choiceService.save(choice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChoice(@PathVariable String id) {
        choiceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
