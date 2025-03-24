package com.assessmate.assessmate_backend.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "quiz")
public class QuizEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quizID")
    private Long quizID;

    @Column(name = "quizTitle", length = 50)
    private String quizTitle;

    @Column(name = "timeLimit")
    private LocalDateTime timeLimit;

    @ManyToOne
    @JoinColumn(name = "classID")
    private ClassEntity class_;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<QuestionEntity> questions;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<QuizAttemptEntity> quizAttempts;

    // Constructors
    public QuizEntity() {
    }

    public QuizEntity(String quizTitle, LocalDateTime timeLimit) {
        this.quizTitle = quizTitle;
        this.timeLimit = timeLimit;
    }

    // Getters and Setters
    public Long getQuizID() {
        return quizID;
    }

    public void setQuizID(Long quizID) {
        this.quizID = quizID;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public LocalDateTime getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(LocalDateTime timeLimit) {
        this.timeLimit = timeLimit;
    }

    public ClassEntity getClass_() {
        return class_;
    }

    public void setClass_(ClassEntity class_) {
        this.class_ = class_;
    }

    public List<QuestionEntity> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionEntity> questions) {
        this.questions = questions;
    }

    public List<QuizAttemptEntity> getQuizAttempts() {
        return quizAttempts;
    }

    public void setQuizAttempts(List<QuizAttemptEntity> quizAttempts) {
        this.quizAttempts = quizAttempts;
    }
}