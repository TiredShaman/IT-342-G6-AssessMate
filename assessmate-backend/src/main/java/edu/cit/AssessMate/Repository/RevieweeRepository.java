package edu.cit.AssessMate.Repository;

import edu.cit.AssessMate.Entity.Reviewee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RevieweeRepository extends JpaRepository<Reviewee, String> {
    Optional<Reviewee> findByEmail(String email);
}