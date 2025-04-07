package edu.cit.AssessMate.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "choices")
public class Choice {
    @Id
    @Column(name = "choice_id", length = 15)
    private String choiceID;

    @Column(name = "question_mc", columnDefinition = "TEXT")
    private String questionMC;

    @Column(name = "is_correct")
    private boolean isCorrect;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    private Question question;

    @OneToOne(mappedBy = "choice", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Answer answer;

    // Constructors
    public Choice() {
    }

    public Choice(String choiceID, String questionMC, boolean isCorrect, Question question) {
        this.choiceID = choiceID;
        this.questionMC = questionMC;
        this.isCorrect = isCorrect;
        this.question = question;
    }

    // Getters and setters
    public String getChoiceID() {
        return choiceID;
    }

    public void setChoiceID(String choiceID) {
        this.choiceID = choiceID;
    }

    public String getQuestionMC() {
        return questionMC;
    }

    public void setQuestionMC(String questionMC) {
        this.questionMC = questionMC;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        // Remove from current question's choices list if changing question
        if (this.question != null) {
            this.question.getChoices().remove(this);
        }
        
        // Set new question and add to its choices list
        this.question = question;
        if (question != null && !question.getChoices().contains(this)) {
            question.getChoices().add(this);
        }
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        if (answer == null) {
            if (this.answer != null) {
                this.answer.setChoice(null);
            }
        } else {
            answer.setChoice(this);
        }
        this.answer = answer;
    }

    // Utility methods
    public boolean isSelected() {
        return answer != null;
    }

    @Override
    public String toString() {
        return "Choice{" +
                "choiceID='" + choiceID + '\'' +
                ", questionMC='" + questionMC + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}