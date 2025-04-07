package edu.cit.AssessMate.Controller;

import edu.cit.AssessMate.Entity.Reviewee;
import edu.cit.AssessMate.Service.RevieweeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviewees")
public class RevieweeController {
    private final RevieweeService revieweeService;

    @Autowired
    public RevieweeController(RevieweeService revieweeService) {
        this.revieweeService = revieweeService;
    }

    @GetMapping
    public List<Reviewee> getAllReviewees() {
        return revieweeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reviewee> getRevieweeById(@PathVariable String id) {
        Optional<Reviewee> reviewee = revieweeService.findById(id);
        return reviewee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Reviewee> getRevieweeByEmail(@PathVariable String email) {
        Optional<Reviewee> reviewee = revieweeService.findByEmail(email);
        return reviewee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Reviewee createReviewee(@RequestBody Reviewee reviewee) {
        return revieweeService.save(reviewee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reviewee> updateReviewee(@PathVariable String id, @RequestBody Reviewee revieweeDetails) {
        Optional<Reviewee> optionalReviewee = revieweeService.findById(id);
        if (optionalReviewee.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Reviewee reviewee = optionalReviewee.get();
        reviewee.setRevieweeFirstName(revieweeDetails.getRevieweeFirstName());
        reviewee.setRevieweeLastName(revieweeDetails.getRevieweeLastName());
        reviewee.setEmail(revieweeDetails.getEmail());
        Reviewee updatedReviewee = revieweeService.save(reviewee);
        return ResponseEntity.ok(updatedReviewee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReviewee(@PathVariable String id) {
        if (revieweeService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        revieweeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
