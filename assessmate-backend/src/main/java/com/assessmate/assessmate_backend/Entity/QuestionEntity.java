package com.assessmate.assessmate_backend.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questionID")
    private Long questionID;

    @Column(name = "questionText", columnDefinition = "TEXT")
    private String questionText;

    @Column(name = "questionType")
    private String questionType; // Enum('MULTIPLE_CHOICE', 'TRUE_FALSE')

    @ManyToOne
    @JoinColumn(name = "quizID")
    private QuizEntity quiz;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<ChoiceEntity> choices;

    // Constructors
    public QuestionEntity() {
    }

    public QuestionEntity(String questionText, String questionType) {
        this.questionText = questionText;
        this.questionType = questionType;
    }

    // Getters and Setters
    public Long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Long questionID) {
        this.questionID = questionID;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public QuizEntity getQuiz() {
        return quiz;
    }

    public void setQuiz(QuizEntity quiz) {
        this.quiz = quiz;
    }

    public List<ChoiceEntity> getChoices() {
        return choices;
    }

    public void setChoices(List<ChoiceEntity> choices) {
        this.choices = choices;
    }
}