package edu.cit.AssessMate.Repository;

import edu.cit.AssessMate.Entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Class, String> {
    List<Class> findByCoachCoachID(String coachID);
    // Custom query methods can be added here
}
