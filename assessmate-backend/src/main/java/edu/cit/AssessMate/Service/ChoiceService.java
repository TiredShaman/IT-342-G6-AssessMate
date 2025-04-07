package edu.cit.AssessMate.Service;

import edu.cit.AssessMate.Entity.Choice;
import edu.cit.AssessMate.Repository.ChoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoiceService {
    private final ChoiceRepository choiceRepository;

    @Autowired
    public ChoiceService(ChoiceRepository choiceRepository) {
        this.choiceRepository = choiceRepository;
    }

    public List<Choice> findByQuestionId(String questionID) {
        return choiceRepository.findByQuestionQuestionID(questionID);
    }

    public List<Choice> findCorrectChoicesByQuestionId(String questionID) {
        return choiceRepository.findByQuestionQuestionIDAndIsCorrect(questionID, true);
    }

    public Choice save(Choice choice) {
        return choiceRepository.save(choice);
    }

    public void deleteById(String choiceID) {
        choiceRepository.deleteById(choiceID);
    }
}
