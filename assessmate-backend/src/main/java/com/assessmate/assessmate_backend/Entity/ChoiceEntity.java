package com.assessmate.assessmate_backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "choice")
public class ChoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "choiceID")
    private Long choiceID;

    @Column(name = "questionMC", columnDefinition = "TEXT")
    private String questionMC;

    @Column(name = "is_Correct")
    private Boolean is_Correct;

    @ManyToOne
    @JoinColumn(name = "questionID")
    private QuestionEntity question;

    // Constructors
    public ChoiceEntity() {
    }

    public ChoiceEntity(String questionMC, Boolean is_Correct) {
        this.questionMC = questionMC;
        this.is_Correct = is_Correct;
    }

    // Getters and Setters
    public Long getChoiceID() {
        return choiceID;
    }

    public void setChoiceID(Long choiceID) {
        this.choiceID = choiceID;
    }

    public String getQuestionMC() {
        return questionMC;
    }

    public void setQuestionMC(String questionMC) {
        this.questionMC = questionMC;
    }

    public Boolean getIs_Correct() {
        return is_Correct;
    }

    public void setIs_Correct(Boolean is_Correct) {
        this.is_Correct = is_Correct;
    }

    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }
}