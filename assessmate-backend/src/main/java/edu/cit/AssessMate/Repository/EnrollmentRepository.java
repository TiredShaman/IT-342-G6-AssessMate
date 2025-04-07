package edu.cit.AssessMate.Repository;

import edu.cit.AssessMate.Entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, String> {
    List<Enrollment> findByClassEntityClassID(String classID);
    List<Enrollment> findByRevieweeRevieweeID(String revieweeID);
}
