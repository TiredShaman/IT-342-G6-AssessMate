package edu.cit.AssessMate.Service;

import edu.cit.AssessMate.Entity.Enrollment;
import edu.cit.AssessMate.Repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public List<Enrollment> findByClassId(String classID) {
        return enrollmentRepository.findByClassEntityClassID(classID);
    }

    public List<Enrollment> findByRevieweeId(String revieweeID) {
        return enrollmentRepository.findByRevieweeRevieweeID(revieweeID);
    }

    public Enrollment save(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public void deleteById(String enrollmentID) {
        enrollmentRepository.deleteById(enrollmentID);
    }
}
