package com.assessmate.assessmate_backend.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "quiz_attempt")
public class QuizAttemptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quizAttemptID")
    private Long quizAttemptID;

    @Column(name = "score")
    private Integer score;

    @Column(name = "started_At")
    private LocalDateTime started_At;

    @Column(name = "submitted_At")
    private LocalDateTime submitted_At;

    @ManyToOne
    @JoinColumn(name = "quizID")
    private QuizEntity quiz;

    @ManyToOne
    @JoinColumn(name = "revieweeID")
    private RevieweeEntity reviewee;

    @OneToMany(mappedBy = "quizAttempt", cascade = CascadeType.ALL)
    private List<AnswerEntity> answers;

    // Constructors
    public QuizAttemptEntity() {
    }

    public QuizAttemptEntity(Integer score, LocalDateTime started_At, LocalDateTime submitted_At) {
        this.score = score;
        this.started_At = started_At;
        this.submitted_At = submitted_At;
    }

    // Getters and Setters
    public Long getQuizAttemptID() {
        return quizAttemptID;
    }

    public void setQuizAttemptID(Long quizAttemptID) {
        this.quizAttemptID = quizAttemptID;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public LocalDateTime getStarted_At() {
        return started_At;
    }

    public void setStarted_At(LocalDateTime started_At) {
        this.started_At = started_At;
    }

    public LocalDateTime getSubmitted_At() {
        return submitted_At;
    }

    public void setSubmitted_At(LocalDateTime submitted_At) {
        this.submitted_At = submitted_At;
    }

    public QuizEntity getQuiz() {
        return quiz;
    }

    public void setQuiz(QuizEntity quiz) {
        this.quiz = quiz;
    }

    public RevieweeEntity getReviewee() {
        return reviewee;
    }

    public void setReviewee(RevieweeEntity reviewee) {
        this.reviewee = reviewee;
    }

    public List<AnswerEntity> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerEntity> answers) {
        this.answers = answers;
    }
}