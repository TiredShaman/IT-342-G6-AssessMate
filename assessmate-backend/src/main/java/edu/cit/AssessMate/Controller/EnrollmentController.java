package edu.cit.AssessMate.Controller;

import edu.cit.AssessMate.Entity.Enrollment;
import edu.cit.AssessMate.Service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping("/class/{classId}")
    public List<Enrollment> getEnrollmentsByClassId(@PathVariable String classId) {
        return enrollmentService.findByClassId(classId);
    }

    @GetMapping("/reviewee/{revieweeId}")
    public List<Enrollment> getEnrollmentsByRevieweeId(@PathVariable String revieweeId) {
        return enrollmentService.findByRevieweeId(revieweeId);
    }

    @PostMapping
    public Enrollment createEnrollment(@RequestBody Enrollment enrollment) {
        return enrollmentService.save(enrollment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable String id) {
        enrollmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}