package edu.cit.AssessMate.Repository;

import edu.cit.AssessMate.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, String> {
    List<Quiz> findByClassEntityClassID(String classID);
}