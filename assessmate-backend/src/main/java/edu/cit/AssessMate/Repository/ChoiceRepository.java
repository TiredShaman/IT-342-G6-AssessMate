package edu.cit.AssessMate.Repository;

import edu.cit.AssessMate.Entity.Choice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChoiceRepository extends JpaRepository<Choice, String> {
    List<Choice> findByQuestionQuestionID(String questionID);
    List<Choice> findByQuestionQuestionIDAndIsCorrect(String questionID, boolean isCorrect);
}
