package edu.cit.AssessMate.Service;

import edu.cit.AssessMate.Entity.Coach;
import edu.cit.AssessMate.Repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CoachService {
    private final CoachRepository coachRepository;
    private final Logger logger = LoggerFactory.getLogger(CoachService.class);

    @Autowired
    public CoachService(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    public List<Coach> findAll() {
        logger.debug("Fetching all coaches with their classes");
        return coachRepository.findAllWithClasses();
    }

    public Optional<Coach> findById(String coachID) {
        logger.debug("Fetching coach with ID: {} including classes", coachID);
        return coachRepository.findByIdWithClasses(coachID);
    }

    public Coach save(Coach coach) {
        logger.info("Starting to save coach with details - Name: {} {}, Institution: {}",
                coach.getCoachFirstName(),
                coach.getCoachLastName(),
                coach.getInstitution());

        try {
            logger.debug("Attempting to save coach to database");
            Coach savedCoach = coachRepository.save(coach);
            logger.info("Successfully saved coach. Saved details - ID: {}, Name: {} {}",
                    savedCoach.getCoachID(),
                    savedCoach.getCoachFirstName(),
                    savedCoach.getCoachLastName());
            return savedCoach;
        } catch (Exception e) {
            logger.error("Error saving coach: {}", e.getMessage(), e);
            throw e;
        }
    }

    public void deleteById(String coachID) {
        logger.info("Deleting coach with ID: {}", coachID);
        coachRepository.deleteById(coachID);
    }
}