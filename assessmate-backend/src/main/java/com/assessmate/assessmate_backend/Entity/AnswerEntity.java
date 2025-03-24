package com.assessmate.assessmate_backend.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "answer")
public class AnswerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answerID")
    private Long answerID;

    @ManyToOne
    @JoinColumn(name = "questionID")
    private QuestionEntity question;

    @Column(name = "submitted_At")
    private LocalDateTime submitted_At;

    @ManyToOne
    @JoinColumn(name = "quizAttemptID")
    private QuizAttemptEntity quizAttempt;

    @ManyToOne
    @JoinColumn(name = "choiceID")
    private ChoiceEntity choice;

    // Constructors
    public AnswerEntity() {
    }

    public AnswerEntity(LocalDateTime submitted_At) {
        this.submitted_At = submitted_At;
    }

    // Getters and Setters
    public Long getAnswerID() {
        return answerID;
    }

    public void setAnswerID(Long answerID) {
        this.answerID = answerID;
    }

    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }

    public LocalDateTime getSubmitted_At() {
        return submitted_At;
    }

    public void setSubmitted_At(LocalDateTime submitted_At) {
        this.submitted_At = submitted_At;
    }

    public QuizAttemptEntity getQuizAttempt() {
        return quizAttempt;
    }

    public void setQuizAttempt(QuizAttemptEntity quizAttempt) {
        this.quizAttempt = quizAttempt;
    }

    public ChoiceEntity getChoice() {
        return choice;
    }

    public void setChoice(ChoiceEntity choice) {
        this.choice = choice;
    }
}