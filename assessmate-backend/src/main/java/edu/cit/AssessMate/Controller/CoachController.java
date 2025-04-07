package edu.cit.AssessMate.Controller;

import edu.cit.AssessMate.Entity.Coach;
import edu.cit.AssessMate.Service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coaches")
@CrossOrigin(origins = "*")
public class CoachController {
    private final CoachService coachService;
    private final Logger logger = LoggerFactory.getLogger(CoachController.class);

    @Autowired
    public CoachController(CoachService coachService) {
        this.coachService = coachService;
        logger.info("CoachController initialized");
    }

    @GetMapping("/getAllCoaches")
    public ResponseEntity<List<Coach>> getAllCoaches() {
        logger.info("Received request to get all coaches");
        try {
            List<Coach> coaches = coachService.findAll();
            logger.info("Found {} coaches", coaches.size());
            return ResponseEntity.ok(coaches);
        } catch (Exception e) {
            logger.error("Error fetching all coaches: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coach> getCoachById(@PathVariable String id) {
        Optional<Coach> coach = coachService.findById(id);
        return coach.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createCoach(@RequestBody Coach coach) {
        try {
            logger.info("Received request to create coach. Request body details:");
            logger.info("Name: {} {}", coach.getCoachFirstName(), coach.getCoachLastName());
            logger.info("Institution: {}", coach.getInstitution());
            logger.info("Specialty: {}", coach.getSpecialty());

            Coach savedCoach = coachService.save(coach);
            logger.info("Successfully created new coach with ID: {}", savedCoach.getCoachID());
            return ResponseEntity.ok(savedCoach);
        } catch (Exception e) {
            logger.error("Error creating coach: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().body("Error creating coach: " + e.getMessage());
        }
    }

    @PutMapping("/updatecoachdetails/{id}")
    public ResponseEntity<?> updateCoach(@PathVariable String id, @RequestBody Coach coachDetails) {
        try {
            logger.info("Received request to update coach with ID: {}", id);
            logger.info("Update details - Name: {} {}, Institution: {}, Specialty: {}",
                    coachDetails.getCoachFirstName(),
                    coachDetails.getCoachLastName(),
                    coachDetails.getInstitution(),
                    coachDetails.getSpecialty());

            Optional<Coach> optionalCoach = coachService.findById(id);
            if (optionalCoach.isEmpty()) {
                logger.warn("Coach with ID {} not found for update", id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Coach not found with ID: " + id);
            }

            Coach existingCoach = optionalCoach.get();
            // Update the fields
            existingCoach.setCoachFirstName(coachDetails.getCoachFirstName());
            existingCoach.setCoachLastName(coachDetails.getCoachLastName());
            existingCoach.setSpecialty(coachDetails.getSpecialty());
            existingCoach.setBio(coachDetails.getBio());
            existingCoach.setInstitution(coachDetails.getInstitution());

            Coach updatedCoach = coachService.save(existingCoach);
            logger.info("Successfully updated coach with ID: {}", id);

            return ResponseEntity.ok(updatedCoach);
        } catch (Exception e) {
            logger.error("Error updating coach with ID {}: {}", id, e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating coach: " + e.getMessage());
        }
    }

    @DeleteMapping("/deletecoach/{id}")
    public ResponseEntity<?> deleteCoach(@PathVariable String id) {
        try {
            logger.info("Received request to delete coach with ID: {}", id);

            Optional<Coach> optionalCoach = coachService.findById(id);
            if (optionalCoach.isEmpty()) {
                logger.warn("Coach with ID {} not found for deletion", id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Coach not found with ID: " + id);
            }

            coachService.deleteById(id);
            logger.info("Successfully deleted coach with ID: {}", id);

            return ResponseEntity.ok("Coach successfully deleted");
        } catch (Exception e) {
            logger.error("Error deleting coach with ID {}: {}", id, e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting coach: " + e.getMessage());
        }
    }
}