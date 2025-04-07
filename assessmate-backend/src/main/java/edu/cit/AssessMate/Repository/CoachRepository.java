package edu.cit.AssessMate.Repository;

import edu.cit.AssessMate.Entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CoachRepository extends JpaRepository<Coach, String> {
    @Query("SELECT DISTINCT c FROM Coach c LEFT JOIN FETCH c.classes WHERE c.coachID = :id")
    Optional<Coach> findByIdWithClasses(@Param("id") String id);

    @Query("SELECT DISTINCT c FROM Coach c LEFT JOIN FETCH c.classes")
    List<Coach> findAllWithClasses();
}