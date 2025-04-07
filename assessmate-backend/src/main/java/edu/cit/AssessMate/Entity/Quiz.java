package edu.cit.AssessMate.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "quizzes")
public class Quiz {
    @Id
    @Column(name = "quiz_id", length = 16)
    private String quizID;

    @Column(name = "quiz_title", length = 50)
    private String quizTitle;

    @Column(name = "time_limit")
    private LocalDateTime timeLimit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    private Class classEntity;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Question> questions;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<QuizAttempt> quizAttempts;

    // Constructors
    public Quiz() {
    }

    public Quiz(String quizID, String quizTitle, LocalDateTime timeLimit, Class classEntity) {
        this.quizID = quizID;
        this.quizTitle = quizTitle;
        this.timeLimit = timeLimit;
        this.classEntity = classEntity;
    }

    // Getters and Setters
    public String getQuizID() {
        return quizID;
    }

    public void setQuizID(String quizID) {
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

    public Class getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(Class classEntity) {
        this.classEntity = classEntity;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<QuizAttempt> getQuizAttempts() {
        return quizAttempts;
    }

    public void setQuizAttempts(List<QuizAttempt> quizAttempts) {
        this.quizAttempts = quizAttempts;
    }

    // Convenience methods for managing bidirectional relationships
    public void addQuestion(Question question) {
        questions.add(question);
        question.setQuiz(this);
    }

    public void removeQuestion(Question question) {
        questions.remove(question);
        question.setQuiz(null);
    }

    public void addQuizAttempt(QuizAttempt quizAttempt) {
        quizAttempts.add(quizAttempt);
        quizAttempt.setQuiz(this);
    }

    public void removeQuizAttempt(QuizAttempt quizAttempt) {
        quizAttempts.remove(quizAttempt);
        quizAttempt.setQuiz(null);
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "quizID='" + quizID + '\'' +
                ", quizTitle='" + quizTitle + '\'' +
                ", timeLimit=" + timeLimit +
                '}';
    }
}